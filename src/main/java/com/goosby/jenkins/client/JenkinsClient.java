package com.goosby.jenkins.client;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.apache.http.HttpException;

import com.goosby.jenkins.httpclient.HttpClient;
import com.goosby.jenkins.model.JobStatus;

public class JenkinsClient {
	private static BufferedReader reader;

	public static void main(String[] args){
		String url = "http://localhost:8080";
		File file = new File("src/main/resources/config_99bill.xml");
		StringBuilder xmlBuilder = new StringBuilder();
		try {
			reader = new BufferedReader(new FileReader(file));
			String line = null;
			while((line = reader.readLine()) != null){
				xmlBuilder.append(line);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		JenkinsClient client = new JenkinsClient();
		client.createJob(url+"/createItem?name=test", xmlBuilder.toString());
	}
	/**
	 * GET
	 * 从HTTP RESPONSE 的header中获取是否有 X-Jenkins
	 * 
	 * @param jenkinsUrl
	 * @param headerName
	 * @return
	 */
	public boolean isJenkins(String jenkinsUrl,String headerName){
		
		boolean result = true;
//		HttpClient client = new HttpClient();
//		String jenkinsVersion = client.getHeaderByName(jenkinsUrl, headerName);
//		if(null == jenkinsVersion || "".equals(jenkinsVersion)){
//			result = false;
//		}
		return result;
	};
	
	/**
	 * 
	 * GET
	 * @param jenkinsUrl
	 * @param headerName
	 * @return
	 */
	public  String getJenkinsVersion(String jenkinsUrl,String headerName){
//		HttpClient client = new HttpClient();
//		String jenkinsVersion = client.getHeaderByName(jenkinsUrl, headerName);
		return "";
	};
	
	/**
	 * jenkinsBaseURL+ "/createItem?name=" + jobName
	 * @param jobName
	 * @param xmlConfig
	 * @return
	 */
	public  boolean createJob(String jobName,String xmlConfig){
		String result = HttpClient.doPost(jobName, xmlConfig);
		System.out.println(result);
		return true;
	};
	
	/**
	 * POST
	 * @param jobName
	 * @param jobXml
	 * @param crumbFlag
	 * @return
	 */
	public  boolean createJob(String jobName, String jobXml, Boolean crumbFlag){
		return true;
	};
	
	/**
	 * POST
	 * jenkinsBaseURL + "/job/"+ jobName + "/config.xml"
	 * @param jobName
	 * @param updateXml
	 * @return
	 */
	public  boolean updateJob(String jobName,String updateXml){
		return true;
	};
	
	/**
	 * POST
	 * jenkinsBaseURL + "/createItem"
	 * NameValuePair n1 = new NameValuePair("name", newJobName);
		NameValuePair n2 = new NameValuePair("mode", "copy");
		NameValuePair n3 = new NameValuePair("from", originJobName);
	 * @param originJobName
	 * @param newJobName
	 * @return
	 */
	public  boolean copyJob(String originJobName, String newJobName){
		return true;
	};
	
	/**
	 * POST
	 * jenkinsBaseURL + "/job/"+ jobName + "/doDelete"
	 * @param jobName
	 * @return
	 */
	public  boolean deleteJob(String jobName){
		return true;
	};
	
	/**
	 * POST
	 * jenkinsBaseURL + "/job/"+ jobName + "/enable"
	 * @param jobName
	 * @return
	 */
	public  boolean enableJob(String jobName){
		return true;
	};
	
	/**
	 * POST
	 * jenkinsBaseURL + "/job/"+ jobName + "/disable"
	 * @param jobName
	 * @return
	 */
	public  boolean disableJob(String jobName){
		return true;
	};
	
	/**
	 * POST
	 * jenkinsBaseURL + "/job/"+ jobName+ "/build"
	 * @param jobName
	 * @return
	 */
	public  String buidlJob(String jobName){
		return null;
	};
	/**
	 * GET
	 * jenkinsBaseURL + "/job/"+ jobName+ "/buildWithParameters?param1=value1
	 * @param jobName
	 * @param parameters
	 * @return
	 */
	public  String buildJobWithParameters(String jobName,Map<String,String> parameters){
		return null;
	};
	
	/**
	 * jenkinsBaseURL + "/job/"+ jobName+ "/lastSuccessfulBuild/buildTimestamp?format=dd/MM/yyyy"
	 * @param jobName
	 * @return
	 */
	public  String getLastSuccessfullBuild(String jobName){
		return null;
	};
	
	/**
	 * GET
	 * jenkinsBaseURL + "/api/xml"
	 * @return
	 * @throws IOException
	 * @throws HttpException
	 * @throws DocumentException
	 */
	public  List<JobStatus> readJobStatus(){
		return null;
	};
			//throws IOException, HttpException,DocumentException {
//		List<JobStatus> jobStatus = new ArrayList<JobStatus>();
//		URL url = new URL("" + "/api/xml");
//		Document dom = new SAXReader().read(url);
//		Element element = dom.getRootElement();
//		if(element == null){
//			return null;
//		}
//		List<Element> elementList = element.elements("job");
//		if(null == elementList || elementList.size() < 1){
//			return null;
//		}
//		for (Element job : elementList) {
//			jobStatus.add(new JobStatus(job.elementText("name"), Status.create(job.elementText("color"))));
//		}
//		return jobStatus;
//	}
	
	/**
	 * 
	 * @param jobName
	 * @return
	 */
	public  String abortBuildJob(String jobName){
		return null;
	};
	
	/**
	 * 
	 * @param jobName
	 * @param buildNumber
	 * @return
	 */
	public  String abortBuilJob(String jobName,long buildNumber){
		return null;
	};
	
	/**
	 * 
	 * @param jobName
	 * @return
	 */
	public  String getJobDetailJSON(String jobName){
		return null;
	};
	
	/**
	 * GET  获取jenkins集群信息（主，从信息）
	 * computer/api/json
	 * @return
	 */
	public  String getJenkinsColony(){
		return null;
	};
	
}
