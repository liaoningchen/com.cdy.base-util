package com.cdy.base.util.util;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class EntityGenerator {

    /**
     * 根据DDL生成实体
     *
     * @param filePath    DDL
     * @param packagePath 包名
     */
    public static void create(String filePath, String packagePath) {
        InputStream is = null;
        String propertyName;
        String typeName;
        String commentStr;
        try {
            is = new FileInputStream(filePath);
            BufferedReader reader = new BufferedReader(new InputStreamReader(is, StandardCharsets.UTF_8), 512);

            StringBuilder sb = new StringBuilder();
            int i = 0;
            String className = "";
            // 读取一行，存储于字符串列表中
            for (String line = reader.readLine(); line != null; line = reader.readLine()) {

                if (line.length() <= 1) {
                    continue;
                }
                if (line.contains("CREATE TABLE")) {
                    if (i != 0) {
                        sb.append("}\n");

                        writeFile(sb, className);
                        sb = new StringBuilder();
                    }

                    i = 1;
                    className = getPropertyName(line);

                    sb.append("\n")
                            .append("package ").append(packagePath).append(";\n\n")
                            .append("import com.daojia.spat.dao.annotation.Column;\n" +
                                    "import com.daojia.spat.dao.annotation.Id;\n" +
                                    "import com.daojia.spat.dao.annotation.NotDBColumn;\n" +
                                    "import com.daojia.spat.dao.annotation.Table;\n" +
                                    "import com.daojia.spat.dsf.serializer.component.annotation.DSFMember;\n" +
                                    "import com.daojia.spat.dsf.serializer.component.annotation.DSFSerializable;\n" +
                                    "\n" +
                                    "import java.io.Serializable;\n" +
                                    "import java.util.Date;\n")
                            .append("\n")
                            .append("@DSFSerializable(name = \"").append(packagePath).append(".").append(className).append("\")\n")
                            .append("@Table(name = \"").append(getName(line)).append("\")\n")
                            .append("public class ").append(className).append(" implements Serializable {\n")
                            .append("    @NotDBColumn\n")
                            .append("    private static final long serialVersionUID = 1L;\n");
                }
                propertyName = getPropertyName(line);
                typeName = getType(line);
                if (!"NULL".equals(typeName) && !"NULL".equals(propertyName)) {
                    commentStr = getComment(line);
                    sb.append("\n    /**\n" + "     * ").append(commentStr).append("\n     */\n");
                    if (line.contains("AUTO_INCREMENT")) {
                        sb.append("    @Id\n");
                    }
                    sb.append("    @DSFMember(sortId = ").append(i++).append(")\n");
                    sb.append("    @Column(name = \"").append(getName(line)).append("\")\n");
                    sb.append("    private ").append(typeName).append(" ").append(propertyName).append(";\n");
                }
            }
            sb.append("}");
            writeFile(sb, className);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (is != null) {
                    is.close();
                    is = null;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private static void writeFile(StringBuilder sb, String className) throws IOException {
        String path = ClassLoader.getSystemClassLoader().getResource("").getPath() + className + ".java";
        System.out.println(path);

        File file = new File(path);
        if (!file.exists()) {
            file.createNewFile();
        }
        try (FileOutputStream out = new FileOutputStream(file)) {
            out.write(sb.toString().getBytes());
        }
    }

    /**
     * 获取对应的java类型
     *
     * @param line
     * @return
     */
    private static String getType(String line) {
        if (line.length() > 1 && !line.contains("CREATE") && !line.contains("PRIMARY") && !line.contains("KEY") && !line.contains("ENGINE=")) {
            line = line.substring(line.lastIndexOf("`") + 2);
            line = line.substring(0, line.indexOf(" "));
            if (line.contains("bigint")) {
                return "Long";
            } else if (line.contains("char")) {//此时也包括 varchar类型
                return "String";
            } else if (line.contains("double")) {
                return "Double";
            } else if (line.contains("int")) {//此时也包括 tinyint类型
                return "Integer";
            } else if (line.contains("date") || line.contains("time")) {//此时也包括 datetime类型
                return "Date";
            }
        }
        return "NULL";
    }

    /**
     * 把字段名转化为驼峰命名的属性名,abc_property ->abcProperty
     *
     * @param line
     * @return
     */
    private static String getPropertyName(String line) {
        if (line.length() > 1 && line.contains("CREATE TABLE")) {
            String tableLimter = getName(line);
            String[] tableLimterArray = tableLimter.split("_");//如果不包含“_”，此时就含有字符串一个元素
            StringBuffer sb = new StringBuffer();
            for (int i = 1; i < tableLimterArray.length; i++) {
                makeFirstUppercase(tableLimterArray, sb, i);
            }
            return sb.toString();
        }
        if (line.length() > 1 && !line.contains("CREATE") && !line.contains("PRIMARY") && !line.contains("KEY") && !line.contains("ENGINE=")) {
            String tempDelimiter = getName(line);
            String[] tempDelimiterArray = tempDelimiter.split("_");//如果不包含“_”，此时就含有字符串一个元素
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < tempDelimiterArray.length; i++) {
                makeFirstUppercase(tempDelimiterArray, sb, i);
            }//for
            return sb.toString();
        }
        return "NULL";
    }

    private static void makeFirstUppercase(String[] tableLimterArray, StringBuffer sb, int i) {
        if (i == 0) {
            sb.append(tableLimterArray[i]);
        }
        if (i != 0) {  //除第一个单词外，其他的单词的首字母大写,String substring(int beginIndex)
            sb.append(tableLimterArray[i].substring(0, 1).toUpperCase() + tableLimterArray[i].substring(1));
        }
    }

    private static String getComment(String line) {
        if (line.contains("COMMENT")) {
            return line.substring(line.lastIndexOf("COMMENT '") + 9, line.lastIndexOf("',"));
        } else if (line.contains("AUTO_INCREMENT")) {
            return "主键Id";
        } else if (line.contains("created_time")) {
            return "创建时间";
        } else if (line.contains("updated_time")) {
            return "修改时间";
        }
        return "NULL";
    }

    private static String getName(String line) {
        return line.substring(line.indexOf("`") + 1, line.lastIndexOf("`"));
    }

}