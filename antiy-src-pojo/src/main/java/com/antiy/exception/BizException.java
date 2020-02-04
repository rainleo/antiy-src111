package com.antiy.exception;


import org.springframework.core.NestedRuntimeException;

/**
 * @auther: yanghaibo
 * @date: 2018/11/21 14:00
 * @description: 所有业务未受检异常父类 spring中的所有异常都可以用 org.springframework.core.NestedRuntimeException来表示Spring在org.springframework.dao包中提供了一套完备优雅的DAO异常体系，
 *              这些异常都继承于 DataAccessException，而DataAccessException本身又继承于 NestedRuntimeException，NestedRuntimeException异常以嵌套的方式封装了源异常。
 *              因为虽然不同持久化技术的特定异常被转换到Spring的DAO异常体系中，原始的异常信息并不会丢失
 *
 */
public class BizException  extends NestedRuntimeException {
    private static final long serialVersionUID = 1L;
	long code;

	public BizException(String message) {
		super(message);
	}

	public BizException(long code, String msg) {
		super(msg);
		this.code = code;
	}

	public BizException(String msg, Throwable throwable) {
		super(msg, throwable);
	}

	public BizException(Throwable throwable) {
		super((throwable==null ? null : throwable.toString()));
	}

	public long getCode() {
		return code;
	}

	public void setCode(long code) {
		this.code = code;
	}
}
