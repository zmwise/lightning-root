package com.osc.app.properties.memcached;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * @description: prefix="org.mybatis.caches.memcached"
 * 				在application.properties配置的属性前缀
 * 				在类中的属性就不用使用{@value}进行注入了
 * @author: lizhiming
 * @since: 2017/11/10
 */
@Component
@ConfigurationProperties(prefix="org.mybatis.caches.memcached")
@PropertySource("classpath:memcached.properties")
public class MemcachedProperties {
	
	private String keyprefix;
	private String servers;
	private String connectionfactory;
	private String expiration;
	private String asyncget;
	private String timeout;
	private String timeoutunit;
	private String compression;
	
	public String getKeyprefix() {
		return keyprefix;
	}
	public void setKeyprefix(String keyprefix) {
		this.keyprefix = keyprefix;
	}
	public String getServers() {
		return servers;
	}
	public void setServers(String servers) {
		this.servers = servers;
	}
	public String getConnectionfactory() {
		return connectionfactory;
	}
	public void setConnectionfactory(String connectionfactory) {
		this.connectionfactory = connectionfactory;
	}
	public String getExpiration() {
		return expiration;
	}
	public void setExpiration(String expiration) {
		this.expiration = expiration;
	}
	public String getAsyncget() {
		return asyncget;
	}
	public void setAsyncget(String asyncget) {
		this.asyncget = asyncget;
	}
	public String getTimeout() {
		return timeout;
	}
	public void setTimeout(String timeout) {
		this.timeout = timeout;
	}
	public String getTimeoutunit() {
		return timeoutunit;
	}
	public void setTimeoutunit(String timeoutunit) {
		this.timeoutunit = timeoutunit;
	}
	public String getCompression() {
		return compression;
	}
	public void setCompression(String compression) {
		this.compression = compression;
	}
}
