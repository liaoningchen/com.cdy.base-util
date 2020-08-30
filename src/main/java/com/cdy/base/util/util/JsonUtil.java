package com.cdy.base.util.util;

import com.google.gson.*;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import org.apache.commons.lang3.StringUtils;

import java.io.IOException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;


public class JsonUtil {

    private static final Gson gson;

    private JsonUtil() {
    }

    static {
        gson = new GsonBuilder().disableHtmlEscaping()
                .registerTypeAdapter(Byte.class, new NumberTypeAdapter<Byte>() {
                    @Override
                    protected Byte valueOf(String string) {
                        return Byte.valueOf(string);
                    }
                })
                .registerTypeAdapter(Short.class, new NumberTypeAdapter<Short>() {
                    @Override
                    protected Short valueOf(String string) {
                        return Short.valueOf(string);
                    }
                })
                .registerTypeAdapter(Integer.class, new NumberTypeAdapter<Integer>() {
                    @Override
                    protected Integer valueOf(String string) {
                        return Integer.valueOf(string);
                    }
                })
                .registerTypeAdapter(Long.class, new NumberTypeAdapter<Long>() {
                    @Override
                    protected Long valueOf(String string) {
                        return Long.valueOf(string);
                    }
                })
                .registerTypeAdapter(Float.class, new NumberTypeAdapter<Float>() {
                    @Override
                    protected Float valueOf(String string) {
                        return Float.valueOf(string);
                    }
                })
                .registerTypeAdapter(Double.class, new NumberTypeAdapter<Double>() {
                    @Override
                    protected Double valueOf(String string) {
                        return Double.valueOf(string);
                    }
                })
                .registerTypeAdapter(Date.class, new DateTypeAdapter())
                .registerTypeAdapterFactory(SingleToArrayTypeAdapter.FACTORY)
                .create();
    }

    public static <T> T fromJson(String json, Class<T> classOfT) {
        return gson.fromJson(json, classOfT);
    }

    public static <T> T fromJson(String json, Type typeOfT) {
        return gson.fromJson(json, typeOfT);
    }

    public static String toJson(Object src) {
        return gson.toJson(src);
    }

    private static abstract class NumberTypeAdapter<T extends Number> extends TypeAdapter<T> {

        @Override
        public void write(JsonWriter out, T value) throws IOException {
            if (value == null) {
                out.nullValue();
                return;
            }
            out.value(value);
        }

        @Override
        public T read(JsonReader in) throws IOException {
            if (in.peek() == JsonToken.NULL) {
                in.nextNull();
                return null;
            }
            try {
                String string = in.nextString();
                return valueOf(string);
            } catch (NumberFormatException e) {
                return null;
            }
        }

        /**
         * 调用具体Number实现类的valueOf方法
         */
        protected abstract T valueOf(String string);
    }

    private static class DateTypeAdapter extends TypeAdapter<Date> {
        private final DateFormat standardDateFormat = buildStandardDateFormat();
        private final DateFormat standardTimeFormat = buildStandardTimeFormat();
        private final DateFormat isoFormat = buildIsoFormat();

        private DateFormat buildStandardDateFormat() {
            return new SimpleDateFormat(DateUtil.DateFormatCnst.STANDARD_DATE_FORMAT, Locale.CHINA);
        }

        private DateFormat buildStandardTimeFormat() {
            return new SimpleDateFormat(DateUtil.DateFormatCnst.STANDARD_DATETIME_FORMAT, Locale.CHINA);
        }

        private DateFormat buildIsoFormat() {
            DateFormat iso8601Format = new SimpleDateFormat(DateUtil.DateFormatCnst.ISO_8601_FORMAT, Locale.US);
            iso8601Format.setTimeZone(TimeZone.getTimeZone("UTC"));
            return iso8601Format;
        }

        @Override
        public Date read(JsonReader in) throws IOException {
            if (in.peek() == JsonToken.NULL) {
                in.nextNull();
                return null;
            }
            return deserializeToDate(in.nextString());
        }

        private synchronized Date deserializeToDate(String json) {
            if (StringUtils.isEmpty(json)) {
                return null;
            }

            /**
             * Gson原生序列化结果 例如 Nov 5, 2017 8:13:10 AM
             */
            final String gsonNativeContainsFlag = ",";
            if (json.contains(gsonNativeContainsFlag)) {
                Gson gson = new Gson();
                return gson.fromJson("\"" + json + "\"", Date.class);
            }

            /**
             * ISO8601 例如 2017-11-05T08:13:10.786Z
             */
            final String iso8601EndsWithFlag = "Z";
            if (json.endsWith(iso8601EndsWithFlag)) {
                try {
                    return isoFormat.parse(json);
                } catch (ParseException e) {
                    throw new JsonSyntaxException(json, e);
                }
            }

            /**
             * standardTimeFormat 例如 2017-11-05 08:13:10
             */
            final String standardTimeFormatFlag = ":";
            if (json.contains(standardTimeFormatFlag)) {
                try {
                    return standardTimeFormat.parse(json);
                } catch (ParseException e) {
                    throw new JsonSyntaxException(json, e);
                }
            }

            /**
             * standardDateFormat 例如 2017-11-05
             */
            final String standardDateFormatFlag = "-";
            if (json.contains(standardDateFormatFlag)) {
                try {
                    return standardDateFormat.parse(json);
                } catch (ParseException e) {
                    throw new JsonSyntaxException(json, e);
                }
            }

            /**
             * 时间戳
             */
            try {
                return new Date(Long.valueOf(json));
            } catch (NumberFormatException e) {
                throw new JsonSyntaxException(json, e);
            }
        }

        @Override
        public synchronized void write(JsonWriter out, Date value) throws IOException {
            if (value == null) {
                out.nullValue();
                return;
            }
            out.value(value.getTime());
        }
    }

    private static final class SingleToArrayTypeAdapter extends TypeAdapter<List<Object>> {
        final TypeAdapter<List<Object>> delegateAdapter;
        final TypeAdapter<Object> elementAdapter;

        public static final TypeAdapterFactory FACTORY = new TypeAdapterFactory() {
            @SuppressWarnings("unchecked")
            @Override
            public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {
                if (type.getRawType() != List.class) {
                    return null;
                }
                Type elementType = ((ParameterizedType) type.getType()).getActualTypeArguments()[0];
                TypeAdapter<List<Object>> delegateAdapter =
                        (TypeAdapter<List<Object>>) gson.getDelegateAdapter(this, type);
                TypeAdapter<Object> elementAdapter =
                        (TypeAdapter<Object>) gson.getAdapter(TypeToken.get(elementType));
                return (TypeAdapter<T>) new SingleToArrayTypeAdapter(delegateAdapter, elementAdapter);
            }
        };

        SingleToArrayTypeAdapter(TypeAdapter<List<Object>> delegateAdapter,
                                 TypeAdapter<Object> elementAdapter) {
            this.delegateAdapter = delegateAdapter;
            this.elementAdapter = elementAdapter;
        }

        @Override
        public List<Object> read(JsonReader reader) throws IOException {
            if (reader.peek() != JsonToken.BEGIN_ARRAY) {
                return Collections.singletonList(elementAdapter.read(reader));
            }
            return delegateAdapter.read(reader);
        }

        @Override
        public void write(JsonWriter writer, List<Object> value)
                throws IOException {
            if (Objects.nonNull(value) && value.size() == 1) {
                elementAdapter.write(writer, value.get(0));
            } else {
                delegateAdapter.write(writer, value);
            }
        }
    }
}


