package com.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.sql.Date;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.bean.Account;
import com.bean.AccountType;
import com.bean.BalanceBean;
import com.bean.Payee;
import com.bean.RoleBean;
import com.bean.UserBean;
import com.bean.category;
import com.bean.expenses;
import com.bean.subCategory;
import com.dao.UserDao;
import com.google.gson.Gson;
import com.service.ImageService;
import com.util.SendMail;

@Controller
public class RegisterServlet {
	
	@Autowired
	UserDao dao;

//----------------------index------------------------------------
	@RequestMapping(value = "/signup", method = RequestMethod.GET)
	public String signup(Model model) {
		System.out.println("Signup Calling");
		model.addAttribute("user", new UserBean());
		return "login";
	}

//--------------------------signup------------------------------------------
	@RequestMapping(value = "/SignUser", method = RequestMethod.GET)
	public String signuser(Model model) {
		System.out.println("Signup Calling");
		model.addAttribute("user", new UserBean());
		return "Signup";
	}

	@GetMapping("/checkemail/{email}")
	@ResponseBody
	public boolean checkEmail(@PathVariable("email") String email) {
		boolean ans = dao.checkDuplicateEmail(email);
		return ans;
	}

	@RequestMapping(value = "/saveuser", method = RequestMethod.POST)
	public String saveUser(@Valid @ModelAttribute("user") UserBean user, BindingResult result,
			@RequestParam("profile") MultipartFile file, Model model) {
		user.setFilepath(ImageService.uploadImage(file, "users"));
		dao.saveUser(user);
		model.addAttribute("myUser", user);
		return "login";

	}

//-----------------------view user profile-----------------------------
	@RequestMapping(value = "/viewProfile", method = RequestMethod.GET)
	public String viewProfile(Model model, HttpSession session) {
		int userID = Integer.parseInt(
				session.getAttribute("id") != null ? (session.getAttribute("id").toString()) : "45".toString());
		List<UserBean> result = dao.viewProfile(userID);
		System.out.println("view user profile");
		model.addAttribute("user", result);
		return "viewProfile";
	}

//-----------------------view pdf by month year date----------------------------------
	@RequestMapping(value = "/viewPdf", method = RequestMethod.POST)
	public String viewPdf(Model model, HttpSession session) {
		System.out.println("view pdf");
		int userID = Integer.parseInt(
				session.getAttribute("id") != null ? (session.getAttribute("id").toString()) : "45".toString());
		List<expenses> result = dao.getAllExpenseDetails(userID);
		model.addAttribute("expenseDetails", result);
		return "generatepdf";
	}

	@RequestMapping(value = "/viewReport", method = RequestMethod.GET)
	public String viewReport(Model model) {
		System.out.println("report Calling");
		return "viewReport";
	}

	@RequestMapping(value = "/viewMonth", method = RequestMethod.GET)
	public String viewMonth(Model model, HttpSession session, @RequestParam("month") int id) {
		System.out.println("month Calling");
		int userID = Integer.parseInt(
				session.getAttribute("id") != null ? (session.getAttribute("id").toString()) : "45".toString());
		List<expenses> result = dao.getAllExpenseDetailsByMonth(userID, id);
		model.addAttribute("expenseDetails", result);
		return "viewMonth";
	}

	@RequestMapping(value = "/viewYear", method = RequestMethod.GET)
	public String viewYear(Model model, HttpSession session, @RequestParam("year") int id) {
		System.out.println("year Calling");
		int userID = Integer.parseInt(
				session.getAttribute("id") != null ? (session.getAttribute("id").toString()) : "45".toString());
		List<expenses> result = dao.getAllExpenseDetailsByYear(userID, id);
		model.addAttribute("expenseDetails", result);
		return "viewYear";
	}

	@RequestMapping(value = "/viewDate", method = RequestMethod.GET)
	public String viewDate(Model model, HttpSession session, @RequestParam("date1") Date date1,
			@RequestParam("date2") Date date2) {
		System.out.println("view date Calling");
		int userID = Integer.parseInt(
				session.getAttribute("id") != null ? (session.getAttribute("id").toString()) : "45".toString());
		List<expenses> result = dao.getAllExpenseDetailsByDate(userID, date1, date2);
		model.addAttribute("expenseDetails", result);
		return "viewDate";
	}

// ---------------------account--------------------------------------------
	@RequestMapping(value = "/account", method = RequestMethod.GET)
	public String account(Model model, Account bean, HttpSession session) {
		System.out.println("Account Calling");
		List<AccountType> list = dao.getTypes();
		model.addAttribute("users", list);
		int id = (Integer) session.getAttribute("id");
		List<Account> list1 = dao.getAccount(id);
		model.addAttribute("account", list1);
		return "Account";
	}

	@RequestMapping(value = "/addAccount", method = RequestMethod.POST)
	public String addAccount(@RequestParam("id") int id, Account bean, Model model, HttpSession session) {
		int n = (Integer) session.getAttribute("id");
		bean.setId(n);
		System.out.println("insert in account");
		dao.addAccount(bean, id);
		return "redirect:/account";

	}

	@GetMapping("/deleteaccount/{id}")
	public String deleteaccount(@PathVariable("id") int id, Model model) {

		boolean flag = dao.getUsersaccount(id);
		return "redirect:/account";

	}

//------------------------------expense ----------------------------------------------------
	@RequestMapping(value = "/expense", method = RequestMethod.GET)
	public String expense(Model model, Account bean, HttpServletRequest request, HttpSession session) {
		System.out.println("expense Calling");
		int userid = (Integer) session.getAttribute("id");
		bean.setId(userid);
		List<AccountType> list = dao.getTypesByUser(userid);
		model.addAttribute("users", list);
		int id = (Integer) session.getAttribute("id");
		List<Payee> list2 = dao.getPayee();
		model.addAttribute("payee", list2);
		List<category> list3 = dao.getCategory();
		model.addAttribute("category", list3);
		List<subCategory> list4 = dao.getsubCategory();
		model.addAttribute("subCategory", list4);
		return "expense";
	}

	@RequestMapping(value = "/addExpenses", method = RequestMethod.POST)
	public String testexpenseForm(@ModelAttribute("expense") expenses expbean,
			@RequestParam("expimage") CommonsMultipartFile file, Model model, HttpSession session) {
		System.out.println("calling testexpense....");
		System.out.println(file.getOriginalFilename());
		System.out.println(file.getContentType());
		byte[] imageDate = file.getBytes();
		String path = session.getServletContext().getRealPath("/") + "WEB-INF" + File.separator + "images"
				+ File.separator + file.getOriginalFilename();
		System.out.println(path);
		expbean.setImage(path);

		try {
			FileOutputStream fos = new FileOutputStream(path);
			fos.write(imageDate);
			fos.close();

		} catch (IOException e) {
			System.out.println(e);
		}
		int userID = Integer.parseInt(
				session.getAttribute("id") != null ? (session.getAttribute("id").toString()) : "45".toString());
		expbean.setUserId(userID);
		System.out.println(userID);
		System.out.println(expbean);
		BalanceBean balacebean = dao.getamountbyuserIDandaccountID(userID, expbean.getUseraccountID());
		if (balacebean != null && balacebean.getAmount() >= expbean.getAmmount()) {
			dao.updatebalance(expbean);
			dao.setexpense(expbean);
			dao.setpayee(expbean.getPayeeName(), expbean.getUserId());
			return "redirect:/expenseDetails";
		} else {
			System.out.println("error");
			return "redirect:/error";

		}
	}

//------------------------expense details--------------------------------------		
	@RequestMapping(value = "/expenseDetails")
	public String expenseDetails(Model model, HttpSession session) {
		System.out.println("expense details");
		int userID = Integer.parseInt(
				session.getAttribute("id") != null ? (session.getAttribute("id").toString()) : "45".toString());
		List<expenses> result = dao.getAllExpenseDetails(userID);

		model.addAttribute("expenseDetails", result);
		System.out.println("expense test");
		return "expenseDetails";
	}

//---------------------------payee payee-category sub category-----------------------------------
	@RequestMapping(value = "/upayee", method = RequestMethod.GET)
	public String addpayee(Model model, HttpSession session) {
		System.out.println("Signup Calling");
		// model.addAttribute("user", new UserBean());
		int id = (Integer) session.getAttribute("id");
		List<Payee> list = dao.userPayee(id);
		model.addAttribute("payee", list);
		return "payee";
	}

	@RequestMapping(value = "/uaddPayee", method = RequestMethod.POST)
	public String addPayee(@Valid @ModelAttribute("user") Payee user, BindingResult result, Model model,
			HttpSession session) {

		int id = (Integer) session.getAttribute("id");
		user.setId(id);
		dao.saveuPayee(user);
		List<Payee> list = dao.userPayee(id);
		model.addAttribute("payee", list);
		return "payee";
	}

	@GetMapping("/editupayee/{id}")
	public String editBypayeeId(@PathVariable("id") int id, Model model) {

		Payee bean = dao.edituPayee(id);
		model.addAttribute("user", bean);
		return "UEditPayee";

	}

	@PostMapping("/updateupayee")
	public String updateexpense(Payee user, Model model) {
		model.addAttribute(dao.updateuPayee(user));
		return "redirect:/upayee";

	}

	@GetMapping("/deleteupayee/{id}")
	public String deletepayee(@PathVariable("id") int id, Model model) {

		boolean flag = dao.deleteuPayeeById(id);
		return "redirect:/upayee";

	}

	@RequestMapping(value = "/payeecategory/{payeeName}", method = RequestMethod.GET, produces = { "application/xml",
			"text/xml" }, consumes = MediaType.ALL_VALUE)
	@ResponseBody
	public List<category> getallCategoryBean(@PathVariable("payeeName") String payeeName) {
		System.out.println(payeeName);
		List<category> result = dao.getallCategoryByPayeeName(payeeName);
		List<String> rslt = new ArrayList<String>();

		return result;

	}

	@RequestMapping(value = "/payeesubcategory/{categoryName}", method = RequestMethod.GET)
	@ResponseBody
	public List<String> getallsubCategory(@PathVariable("categoryName") String categoryName) {
		List<String> result = dao.getallsubCategoryByCategoryName(categoryName);
		return result;

	}

//------------------------category-----------------------------------
	@RequestMapping(value = "/ucategory", method = RequestMethod.GET)
	public String ucategory(Model model, HttpSession session) {
		System.out.println(" Calling");
		int id = (Integer) session.getAttribute("id");
		List<Payee> list = dao.userPayee(id);
		model.addAttribute("payee", list);
		List<category> list1 = dao.userCategory(id);
		model.addAttribute("category", list1);
		return "category";
	}

	@RequestMapping(value = "/uaddCategory", method = RequestMethod.POST)
	public String uaddCategory(@Valid @ModelAttribute("user") category user, BindingResult result,
			@RequestParam("id") int cid, Model model, HttpSession session) {

		int id = (Integer) session.getAttribute("id");
		user.setId(id);
		dao.saveuCategory(user, cid);
		return "redirect:/ucategory";
	}

	@GetMapping("/editucategory/{id}")
	public String editByucategoryId(@PathVariable("id") int id, Model model) {

		category bean = dao.edituCategory(id);
		model.addAttribute("user", bean);
		return "UEditCategory";

	}

	@PostMapping("/updateucategory")
	public String updateucategory(category user, Model model) {

		model.addAttribute(dao.updateuCategory(user));
		return "redirect:/ucategory";

	}

	@GetMapping("/deleteucategory/{id}")
	public String deletecategory(@PathVariable("id") int id, Model model) {

		boolean flag = dao.deleteCategoryById(id);
		return "redirect:/ucategory";

	}

//------------------------sub category-----------------------------------
	@RequestMapping(value = "/usubcategory", method = RequestMethod.GET)
	public String usubcategory(Model model, HttpSession session) {
		System.out.println(" Calling");
		// model.addAttribute("user", new UserBean());
		int id = (Integer) session.getAttribute("id");
		List<category> list1 = dao.userCategory(id);
		model.addAttribute("category", list1);
		List<subCategory> list = dao.getsubCategory();
		model.addAttribute("sub", list);
		return "subcategory";
	}

	@RequestMapping(value = "/uaddSub", method = RequestMethod.POST)
	public String uaddCategory(@Valid @ModelAttribute("user") subCategory user, BindingResult result,
			@RequestParam("id") int id,HttpSession session) {
		int id1 = (Integer) session.getAttribute("id");
		user.setId(id1);
		dao.saveusubCategory(user, id);
		return "redirect:/usubcategory";
	}

	@GetMapping("/editusubcategory/{id}")
	public String editBysubcategoryId(@PathVariable("id") int id, Model model) {

		subCategory bean = dao.edituSubCategory(id);
		model.addAttribute("user", bean);
		return "UEditSub";

	}

	@PostMapping("/updateusubcategory")
	public String updateusubcategory(subCategory user, Model model) {
		model.addAttribute(dao.updateuSubCategory(user));
		return "redirect:/usubcategory";

	}

	@GetMapping("/deleteusubcategory/{id}")
	public String deletesubcategory(@PathVariable("id") int id, Model model) {

		boolean flag = dao.deleteSubCategoryById(id);
		return "redirect:/usubcategory";

	}

//-----------------------list users-----------------------------
	@RequestMapping(value = "/getAll", method = RequestMethod.GET)
	public String getAll(Model model) {
		model.addAttribute("users", dao.getUsers());
		return "listUsers";

	}

//------------------------delete users-------------------------------
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable("id") int id) {

		boolean flag = dao.delUser(id);
		return "redirect:/getAll";

	}

	@GetMapping("/deleteexpense/{id}")
	public String deleteexpense(@PathVariable("id") int id, Model model) {

		boolean flag = dao.getUserexpense(id);

		List<AccountType> list = dao.getTypes();
		model.addAttribute("users", list);
		return "redirect:/expenseDetails";

	}

//-----------------------edit and update user------------------------------
	@GetMapping("/EditUser/{id}")
	public String editById(@PathVariable("id") int id, Model model) {
		UserBean bean = dao.editById(id);
		model.addAttribute("user", bean);
		return "EditUser";

	}

	@PostMapping("/update")
	public String update(UserBean user, Model model) {
		model.addAttribute(dao.update(user));
		model.addAttribute("users", dao.getUsers());
		return "listUsers";

	}

//--------------------------------edit expense-----------------------------------	

	@GetMapping("/editexpense/{id}")
	public String editByexpenseId(@PathVariable("id") int id, Model model) {
		List<AccountType> list = dao.getTypes();
		model.addAttribute("users", list);
		expenses bean = dao.editByexpenseId(id);
		model.addAttribute("user", bean);
		return "EditExpense";

	}

	@PostMapping("/updateexpense")
	public String updateexpense(expenses user, Model model, expenses expbean, HttpSession session) {
		model.addAttribute(dao.updateexpense(user));

		/*
		 * int userID = Integer.parseInt( session.getAttribute("id") != null ?
		 * (session.getAttribute("id").toString()) : "45".toString());
		 * expbean.setUserId(userID); BalanceBean balacebean =
		 * dao.getamountbyuserIDandaccountID(userID, expbean.getUseraccountID()); if
		 * (balacebean != null && balacebean.getAmount() >= expbean.getAmmount()) {
		 * dao.updatebalance(expbean); return "redirect:/expenseDetails"; }
		 * 
		 * else { System.out.println("error..........................>>"); return
		 * "redirect:/error";
		 * 
		 * }
		 */
		return "redirect:/expenseDetails";
	}

//-----------------------edit account--------------------------------------	
	@GetMapping("/editaccount/{id}")
	public String editByaccountId(@PathVariable("id") int id, Model model) {

		Account bean = dao.editAccount(id);
		model.addAttribute("user", bean);
		return "EditAccount";

	}

	@PostMapping("/updateAccount")
	public String updateaccount(Account user, Model model) {
		model.addAttribute(dao.updateAcc(user));
		return "redirect:/account";

	}

//-----------------------------add user-------------------------------
	@RequestMapping(value = "/adduser", method = RequestMethod.POST)
	public String adduser(@Valid @ModelAttribute("user") UserBean user, BindingResult result, Model model) {
		if (result.hasErrors()) {
			model.addAttribute("myUser", user);
			return "Adduser";
		} else {
			dao.saveUser(user);
			model.addAttribute("myUser", user);
			return "home";
		}
	}

//--------------------------------login-----------------------------------
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(UserBean user, Model model, HttpSession session, HttpServletRequest reuest) {
		System.out.println(user);
		UserBean result1 = dao.getUsers1(user);
		if (result1 == null) {
			return "login";
		} else if (result1.getRoleName().getRoleName().equals("admin")) {
			List<UserBean> user1 = dao.getUsers();
			session.setAttribute("id", result1.getUserId());
			model.addAttribute("list", user1);
			List<RoleBean> list = dao.getRoles();
			model.addAttribute("role", list);
			return "AddRole";
		} else if (result1.getRoleName().getRoleName().equals("user")) {
			session.setAttribute("id", result1.getUserId());
			List<AccountType> list = dao.getTypes();
			model.addAttribute("users", list);
			int id = (Integer) session.getAttribute("id");
			List<Account> list1 = dao.getAccount(id);
			model.addAttribute("account", list1);
			return "Account";
		}
		System.out.println(result1);
		return "login";

	}

//-------------------------------logout-------------------------------
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(Model model, HttpSession session) {
		session.invalidate();
		return "login";

	}

//------------------------forget and new password -----------------------------
	@RequestMapping(value = "/forget", method = RequestMethod.GET)
	public String forget(@Valid @ModelAttribute("user") UserBean user, BindingResult result, Model model) {
		return "forget";

	}

	@RequestMapping(value = "/forgetPassword", method = RequestMethod.POST)
	public String forgetPassword(UserBean user, Model model) {
		model.addAttribute("email", user.getEmail());
		System.out.println(user.getEmail());
		System.out.println(user);
		SendMail.sendMail();
		UserBean result1 = dao.forget(user);
		System.out.println(result1);
		if (result1 != null) {
			return "otp";
		} else {
			model.addAttribute("error", "please enter correct email");
			return "forget";
		}

	}

	@RequestMapping(value = "/newpass", method = RequestMethod.POST)
	public String newpass(@RequestParam("pass1") String pass, @RequestParam("email") String email, Model model) {
		model.addAttribute("users", email);
		System.out.println(email);
		boolean flag = dao.updatePassword(email, pass);
		System.out.println(flag);
		if (flag) {
			return "NewPass";

		} else {
			return "login";
		}

	}

//----------------------------------otp-----------------------------------------
	@PostMapping("/otp")
	public String otp(@RequestParam("number") String number, @RequestParam("email") String email, PrintWriter out,
			Model model) {
		model.addAttribute("users", email);
		System.out.println(email);
		System.out.println(number);
		if (number.equals(SendMail.otp)) {
			return "NewPass";
		} else {
			return "otp";
		}
	}

	@RequestMapping(value = "/viewImage", method = RequestMethod.POST)
	public String viewImages(@RequestParam("imageurl") String image2, Model model) {
		System.out.println("viewImage" + image2);
		model.addAttribute("imageurl", image2);
		return "ViewImages";
	}

}