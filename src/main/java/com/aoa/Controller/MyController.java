package com.aoa.Controller;

import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.aoa.entity.Computer;
import com.aoa.entity.User;
import com.aoa.service.ComputerService;
import com.aoa.service.UserService;

@Controller
public class MyController {

	@Autowired
	@Qualifier("userService")
	private UserService us;

	private List<User> userList;
	private List<User> userListAll;
	private List<User> userListIdList;

	@Autowired
	@Qualifier("computerService")
	private ComputerService cs;

	private List<Computer> comList;

	@RequestMapping(value = "/login")
	public String login() {
		return "login";
	}

	@RequestMapping(value = "/userlogin", method = RequestMethod.POST)
	public String userlogin(String username, String password, String q, Model model, HttpServletRequest request) {

		System.out.println(username + " " + password + " " + q);
		userList = us.findLogin(username, password, q);
		userListAll = us.findAll();
		String name = userList.get(0).getuName();
		request.getSession().setAttribute("name", name);
		comList=cs.findAll();
		for (User user : userList) {
			System.out.println(user);
		}
		for (Computer c : comList) {
			System.out.println(c);
		}
		if (userList != null && userList.get(0).getuQ().equals("1")) {
			model.addAttribute("name", name);
			model.addAttribute("user", userListAll);
			model.addAttribute("computer", comList);

			return "managerLoginAfter";
		} else if (userList != null && userList.get(0).getuQ().equals("0")) {
			model.addAttribute("name", name);
			model.addAttribute("user", userList);
			return "userLoginAfter";
		} else {

			return "login";
		}
	}

	@RequestMapping(value = "/jump")
	public String Jump() {
		return "register";

	}

	@RequestMapping(value = "/jump1")
	public String Jump1(int id, HttpServletRequest value, Model model) {
		userListIdList = us.fingById(id);
		for (User user : userListIdList) {
			System.out.println(user);
		}
		model.addAttribute("userid", userListIdList);
		return "update1";

	}

	@RequestMapping(value = "/update")
	public String update(int id, String username, String password, String q, int sex, int tel, Model model,
			HttpServletRequest request) throws UnsupportedEncodingException {
		String sex1;
		if (sex == 1) {
			sex1 = "男";
		} else {
			sex1 = "女";
		}
		String newname = new String(username.trim().getBytes("ISO-8859-1"), "UTF-8");
		int num = 0;
		num = us.updateById(id, newname, password, q, sex1, tel);
		System.out.println(num);

		userList = us.findAll();

		if (num > 0) {
			System.out.println("修改成功！" + num);
			model.addAttribute("name", request.getSession().getAttribute("name"));
			model.addAttribute("user", userList);

			return "managerLoginAfter";
		} else {
			System.out.println("修改失败！" + num);
		}

		return "defeated";

	}

	@RequestMapping(value = "/delete")
	public String delete(int id, Model model, HttpServletRequest request) {

		int num = 0;
		num = us.deleteById(id);

		userList = us.findAll();

		if (num > 0) {
			System.out.println("删除成功！" + num);
			model.addAttribute("name", request.getSession().getAttribute("name"));
			model.addAttribute("user", userList);
			return "managerLoginAfter";
		} else {
			System.out.println("删除失败！" + num);
		}

		return "defeated";

	}

	@RequestMapping(value = "/register")
	public String register(String username, String password, String q, Integer sex, int tel, Model model,
			HttpServletRequest request) throws UnsupportedEncodingException {
		String sex1;
		if (sex == 1) {
			sex1 = "男";
		} else {
			sex1 = "女";
		}
		String newname = new String(username.trim().getBytes("ISO-8859-1"), "UTF-8");
		int num = 0;
		num = us.findInsert(newname, password, q, sex1, tel);

		userList = us.findAll();

		if (num > 0) {
			System.out.println("插入成功！" + num);
			/*model.addAttribute("name", request.getSession().getAttribute("name"));
			model.addAttribute("user", userList);*/

			return "login";
		} else {
			System.out.println("插入失败！" + num);
		}

		return "defeated";

	}
}
