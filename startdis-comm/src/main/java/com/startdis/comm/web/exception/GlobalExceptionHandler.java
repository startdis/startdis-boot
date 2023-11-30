package com.startdis.comm.web.exception;

import com.startdis.comm.core.enums.CommonExceptionCode;
import com.startdis.comm.domain.bean.ResultBean;
import com.startdis.comm.exception.custom.BusinessException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingRequestHeaderException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.multipart.MaxUploadSizeExceededException;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.stream.Collectors;

/**
 * @author Startdis
 * @email startdis@yundingshuzi.cn
 * @desc GlobalExceptionHandler
 */
@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {

    /**
     * 全局异常
     *
     * @return R
     */
    @ResponseStatus(HttpStatus.OK)
    @ExceptionHandler(Exception.class)
    public ResultBean<?> exception(Exception e) {
        log.error("全局异常信息 ex={}", e.getMessage(), e);
        return ResultBean.error("System Error");
    }

    /**
     * 业务异常
     */
    @ResponseStatus(HttpStatus.OK)
    @ExceptionHandler(BusinessException.class)
    public ResultBean<?> businessException(BusinessException e) {
        log.error("全局业务异常信息 ex={}", e.getMessage(), e);
        return ResultBean.error(e.getCode(), e.getMessage(), e.getData());
    }

    /**
     * 上传异常
     */
    @ResponseBody
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(MaxUploadSizeExceededException.class)
    public ResultBean handleMaxUploadSizeExceededException(MaxUploadSizeExceededException e){
        log.error("文件上传太大异常 ex={}", e.getMessage(), e);
        return ResultBean.error("Upload file too large");
    }

    /**
     * 非法参数异常
     */
    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResultBean<?> illegalArgumentException(IllegalArgumentException e) {
        log.error("非法参数异常 : {}", e.getMessage(), e);
        return ResultBean.error(CommonExceptionCode.ILLEGAL_ARGUMENT.getCode(), e.getMessage());
    }

    /**
     * 处理Get请求中 使用@Valid 验证路径中请求实体校验失败后抛出的异常，详情继续往下看代码
     */
    @ExceptionHandler(BindException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
    public ResultBean<?> bindExceptionHandler(BindException e) {
        String message = e.getBindingResult().getAllErrors().stream().map(DefaultMessageSourceResolvable::getDefaultMessage).collect(Collectors.joining(", "));
        log.warn(message, e);
        return ResultBean.error(CommonExceptionCode.ILLEGAL_ARGUMENT.getCode(), message);
    }

    /**
     * 处理请求参数格式错误 @RequestParam上validate失败后抛出的异常是javax.validation.ConstraintViolationException
     */
    @ExceptionHandler(ConstraintViolationException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
    public ResultBean<?> constraintViolationExceptionHandler(ConstraintViolationException e) {
        String message = e.getConstraintViolations().stream().map(ConstraintViolation::getMessage).collect(Collectors.joining(", "));
        log.warn(message, e);
        return ResultBean.error(CommonExceptionCode.ILLEGAL_ARGUMENT.getCode(), message);
    }

    /**
     * 处理请求参数格式错误 @RequestBody上validate失败后抛出的异常是MethodArgumentNotValidException异常。
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
    public ResultBean<?> methodArgumentNotValidExceptionHandler(MethodArgumentNotValidException e) {
        String message = e.getBindingResult().getAllErrors().stream().map(DefaultMessageSourceResolvable::getDefaultMessage).collect(Collectors.joining(", "));
        log.warn(message, e);
        return ResultBean.error(CommonExceptionCode.ILLEGAL_ARGUMENT.getCode(), message);
    }

    /**
     * 处理请求数据格式异常，比如JSON格式错误。
     */
    @ExceptionHandler(HttpMessageNotReadableException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResultBean<?> httpMessageNotReadableExceptionHandler(HttpMessageNotReadableException e) {
        String message = e.getCause() == null ? e.getMessage() : e.getCause().getMessage();
        log.warn(message, e);
        return ResultBean.error(CommonExceptionCode.ILLEGAL_ARGUMENT.getCode(), message);
    }

    /**
     * 缺少请求头参数
     */
    @ExceptionHandler(MissingRequestHeaderException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResultBean<?> missingRequestHeaderException(MissingRequestHeaderException e) {
        String message = e.getCause() == null ? e.getMessage() : e.getCause().getMessage();
        log.warn(message, e);
        return ResultBean.error(CommonExceptionCode.ILLEGAL_ARGUMENT.getCode(), message);
    }


    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.METHOD_NOT_ALLOWED)
    public ResultBean<?> httpRequestMethodNotSupportedException(HttpRequestMethodNotSupportedException e) {
        String message = e.getCause() == null ? e.getMessage() : e.getCause().getMessage();
        log.warn(message, e);
        return ResultBean.error(CommonExceptionCode.ILLEGAL_ARGUMENT.getCode(), message);
    }

    @ExceptionHandler(MissingServletRequestParameterException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResultBean<?> missingServletRequestParameterException(MissingServletRequestParameterException e) {
        String message = String.format("参数 %s 不存在", e.getParameterName());
        log.warn(message, e);
        return ResultBean.error(CommonExceptionCode.ILLEGAL_ARGUMENT.getCode(), message);
    }

}

