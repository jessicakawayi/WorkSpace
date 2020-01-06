package com.aoa.test;

import org.mortbay.jetty.NCSARequestLog;
import org.mortbay.jetty.Server;
import org.mortbay.jetty.handler.RequestLogHandler;
import org.mortbay.jetty.nio.SelectChannelConnector;
import org.mortbay.jetty.servlet.Context;
import org.mortbay.jetty.servlet.ServletHolder;
import org.mortbay.thread.QueuedThreadPool;

public class JettyServerMain {
	public static void main(String[] args) {
		int port = 8080;
		Server server = new Server();

		//connectors handle network connections
		SelectChannelConnector connector = new SelectChannelConnector();
		connector.setPort(port);
		server.addConnector(connector);

		//create thread pool with 100 threads
		QueuedThreadPool threadPool = new QueuedThreadPool();
		threadPool.setMinThreads(100);
		threadPool.setMaxThreads(100);
		server.setThreadPool(threadPool);

		//specify log file
		String logPath=getlogpath();
		NCSARequestLog requestLog=new NCSARequestLog(logPath+"/jetty-yyyy-mm-dd-request.log");
		requestLog.setRetainDays(3);
		requestLog.setAppend(true);
		requestLog.setExtended(true);
		requestLog.setLogTimeZone("EST");

		//create sample registration for StatusServlet
		Context statusServlet=new Context(server, "/Status",Context.SESSIONS);
		statusServlet.addServlet(new ServletHolder(), "/*");

		//create log handle for StatusServlet
		RequestLogHandler logHandler=new RequestLogHandler();
		logHandler.setRequestLog(requestLog);
		statusServlet.addHandler(logHandler);

		//start the server
		try {
			server.start();
		} catch (Exception e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
	}

	private static String getlogpath() {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	};
}
