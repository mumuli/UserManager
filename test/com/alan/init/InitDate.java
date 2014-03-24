/**
 * 
 */
package com.alan.init;


import java.util.Calendar;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.alan.manager.GroupManager;
import com.alan.manager.UserManager;
import com.alan.po.Group;
import com.alan.po.User;

/**
 * @author chenchen
 *
 */
public class InitDate {
	public static void main(String[] args) {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext-*.xml");
		
		UserManager userMgr = applicationContext.getBean("userMgr", UserManager.class);
		GroupManager groupMgr = applicationContext.getBean("groupMgr", GroupManager.class);
		
		Group g1 = new Group();
		g1.setName("½²Ê¦");
		groupMgr.add(g1);
		
		Group g2 = new Group();
		g2.setName("½ÌÊÚ");
		groupMgr.add(g2);
		
		Calendar c = Calendar.getInstance();
		for(int i = 0; i < 100; i++) {
			c.set(1980, 1, 1);
			int month = (int)(Math.random() * 240);
			c.add(Calendar.MONTH, month);
			
			User user = new User();
			user.setName("well_" + (i + 1));
			user.setBirthday(c.getTime());
			
			c.add(Calendar.MONTH, 240);
			user.setHireDate(c.getTime());
			
			int groupId = (int)(Math.random() * 2);
			if (groupId == 0) {
				user.setGroup(g1);
			} else {
				user.setGroup(g2);
			}
			
			userMgr.add(user);
		}
	}
}
