package com.cdy.base.util.util;

import lombok.extern.slf4j.Slf4j;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;

/**
 * @auther: liansheng
 * @Date: 2020/2/8 16:49
 * @Description:
 */
public class DSFResponseHandler<T> {

    private final Response<?, T> response;
    private String apiName = null;
    private List<Object> params = new LinkedList<>();

    public DSFResponseHandler(Response<?, T> response) {
        this.response = response;
    }

    public static <T> DSFResponseHandler<T> scan(Response<?, T> response) {
        return new DSFResponseHandler(response);
    }

    public DSFResponseHandler<T> apiName(String apiName) {
        this.apiName = apiName;
        return this;
    }

    public DSFResponseHandler<T> param(Object... params) {
        for (Object param : params) {
            this.params.add(param);
        }
        return this;
    }

    public ResponseStream<T> stream() {
        StringBuilder sb = (new StringBuilder()).append(apiName).append(" param: ").append(params.stream().map(JsonUtil::toJson).collect(Collectors.joining(",")));
        return ResponseStream.newInstanceByDSFResponse(() -> response, sb.toString());
    }

    public T result() {
        return stream().result();
    }

    public static abstract class Response<Rsp, T> {

        protected Rsp wrapper;

        public Response(Rsp wrapper) {
            this.wrapper = wrapper;
        }

        public DSFResponseHandler<T> handler() {
            return DSFResponseHandler.scan(this);
        }

        public abstract T getRst();

        public abstract boolean isSuccess();

        public abstract String desc();

        public int code() {
            return 0;
        }

    }

    public static class DefaultResponse<T> extends Response<T, T> {

        public static <T> DSFResponseHandler<T> handle(T wrapper) {
            return new DefaultResponse<>(wrapper).handler();
        }

        public DefaultResponse(T wrapper) {
            super(wrapper);
        }

        @Override
        public T getRst() {
            return wrapper;
        }

        @Override
        public boolean isSuccess() {
            return Objects.nonNull(wrapper);
        }

        @Override
        public String desc() {
            return "";
        }
    }

    @Slf4j
    public static class ResponseStream<Rst> {
        private Function<Response<?, Rst>, Rst> successFun = (response) -> response.getRst();
        private Function<Response<?, Rst>, Rst> failureFun = (response) -> null;
        private Supplier<? extends Response<?, Rst>> supplier;
        private String desc;
        private Boolean showLog = true;

        ResponseStream(Supplier<Response<?, Rst>> supplier, String desc) {
            this.supplier = supplier;
            this.desc = desc;
        }

        public static <Rst> ResponseStream<Rst> newInstanceByDSFResponse(Supplier<? extends Response<?, Rst>> supplier, String desc) {
            return new ResponseStream(supplier, desc);
        }

        public ResponseStream<Rst> success(Function<Response<?, Rst>, Rst> successFun) {
            this.successFun = successFun;
            return this;
        }

        public ResponseStream<Rst> failure(Function<Response<?, Rst>, Rst> failureFun) {
            this.failureFun = failureFun;
            return this;
        }

        public ResponseStream<Rst> showLog(boolean showLog) {
            this.showLog = showLog;
            return this;
        }

        public Rst result() {
            Response<?, Rst> response = null;

            try {
                response = this.supplier.get();
                if (this.showLog) {
                    log.info(this.desc + " ,response:" + JsonUtil.toJson(response));
                }
            } catch (Exception var3) {
                log.error(this.desc + " ,error happened!!!", var3);
            }

            if (response != null && response.isSuccess()) {
                return this.successFun.apply(response);
            } else {
                return this.failureFun.apply(response);
            }
        }

        public <T> T data(Function<Rst, T> handleFun) {
            return handleFun.apply(result());
        }
    }

}
