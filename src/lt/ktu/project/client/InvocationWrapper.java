package lt.ktu.project.client;


import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

public class InvocationWrapper {
	
	
	
	public static <T> T invokeGet(WebTarget parent, String path, Class<T> clazz) {
		return invokeGet(parent, path, clazz, MediaType.APPLICATION_JSON_TYPE);
	}
		
		public static <T, R> R invokeGet(WebTarget parent, String path, Class<R> clazz, MediaType mediaType) {
			WebTarget target = parent.path(path);
			Invocation invocation = target.request(mediaType)
					.buildGet();
			return invocation.invoke(clazz);
		}
		
		public static <T, R> R invokePost(WebTarget parent, String path, T value, Class<R> clazz) {
			WebTarget target = parent.path(path);
			Invocation invocation = target.request(MediaType.APPLICATION_JSON)
					.buildPost(Entity.entity(value, MediaType.APPLICATION_JSON));
			return invocation.invoke(clazz);
		}
		
		public static <T> T invokePut(WebTarget parent, String path, T value, Class<T> clazz) {
			WebTarget target = parent.path(path);
			Invocation invocation = target.request(MediaType.APPLICATION_JSON)
					.buildPut(Entity.entity(value, MediaType.APPLICATION_JSON));
			return invocation.invoke(clazz);
		}
		
		public static <T> T invokeDelete(WebTarget parent, String path, T value, Class<T> clazz) {
			WebTarget target = parent.path(path);
			Invocation invocation = target.request(MediaType.APPLICATION_JSON).buildDelete();
			return invocation.invoke(clazz);
		}
}
