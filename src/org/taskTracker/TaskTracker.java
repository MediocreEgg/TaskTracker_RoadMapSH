package org.taskTracker;

import java.nio.file.Paths;
import java.time.LocalDate;

import org.taskTracker.backend.jsonParser.JSONContext;
import org.taskTracker.backend.jsonParser.Marshaller;
import org.taskTracker.backend.pojo.TaskPOJO;
import org.taskTracker.backend.pojo.TaskStatus;

public class TaskTracker {

	public static void main(String[] args) {
		TaskPOJO pojo = new TaskPOJO.Builder(1, "Hello", LocalDate.now(), TaskStatus.NOTDONE).build();
		JSONContext context = JSONContext.newInstance(TaskPOJO.class);

		Marshaller marshaller = context.createMarshaller();
		marshaller.marshal(pojo, Paths.get("C:\\Users\\topac\\Desktop\\J.json"));
//    	SwingUtilities.invokeLater(new Runnable() {
//
//			@Override
//			public void run() {
//				userInterface frame = new userInterface();
//			}
//    		
//    	});
	}
}
