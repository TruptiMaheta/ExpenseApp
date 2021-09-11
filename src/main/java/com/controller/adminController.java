package com.controller;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
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

import com.bean.AccountType;
import com.bean.Payee;
import com.bean.RoleBean;
import com.bean.category;
import com.bean.expenses;
import com.bean.subCategory;
import com.dao.UserDao;

@Controller
public class adminController {

	@Autowired
	UserDao dao;
	
//--------------------------role-----------------------------------------
		@RequestMapping(value = "/role", method = RequestMethod.GET)
		public String role(Model model) {
			System.out.println("role Calling");
			List<RoleBean> list = dao.getRoles();
			model.addAttribute("role", list);
			return "AddRole";
		}

		@RequestMapping(value = "/addRole", method = RequestMethod.POST)
		public String addRole(@Valid @ModelAttribute("user") RoleBean user, BindingResult result, Model model) {
			dao.saveRole(user);
			return "redirect:/role";
		}
		
//-----------------------------------account type------------------------------------------------
		@RequestMapping(value = "/type", method = RequestMethod.GET)
		public String type(Model model) {
			System.out.println("account type Calling");
			List<AccountType> list = dao.getTypes();
			model.addAttribute("role", list);
			return "addType";
		}

		@RequestMapping(value = "/addType", method = RequestMethod.POST)
		public String addType(@Valid @ModelAttribute("user") AccountType user, BindingResult result, Model model) {
			dao.saveType(user);
			return "redirect:/type";
		}
		
//----------------------------show,edit,update,delete expense------------------------------------------------------
		@RequestMapping(value = "/allexpense")
		public String allexpense(Model model) {
			System.out.println("expense details....................................>>");
			
			List<expenses> result = dao.getAllExpense();
			model.addAttribute("expenseDetails", result);
			System.out.println("expense test");
			return "aexpenseDetails";
		}
		
		@GetMapping("/aeditexpense/{id}")
		public String aeditByexpenseId(@PathVariable("id") int id, Model model) {
			expenses bean = dao.editByexpenseId(id);
			model.addAttribute("user", bean);
			return "AeditExpense";

		}
		
		@PostMapping("/aupdateexpense")
		public String aupdateexpense(expenses user, Model model) {
			model.addAttribute(dao.updateexpense(user));	
			//model.addAttribute("users", dao.getAllExpenseDetails(userID));
			return "redirect:/allexpense";

		}
		
		@GetMapping("/adeleteexpense/{id}")
		public String adeleteexpense(@PathVariable("id") int id, Model model) {

			boolean flag = dao.delExpense(id);
			List<AccountType> list = dao.getTypes();
			model.addAttribute("users", list);
			return "redirect:/allexpense";

		}

//---------------------------add,edit,update,delete payee -----------------------------------
		@RequestMapping(value = "/payee", method = RequestMethod.GET)
		public String payee(Model model) {
			System.out.println("payee Calling");
			List<Payee> list = dao.getPayee();
			model.addAttribute("payee", list);
			return "addPayee";
		}

		@RequestMapping(value = "/addPayee", method = RequestMethod.POST)
		public String addpayee(@Valid @ModelAttribute("user") Payee user, BindingResult result, Model model) {
			dao.savePayee(user);	
			return "redirect:/payee";
		}

		
		@GetMapping("/editpayee/{id}")
		public String editBypayeeId(@PathVariable("id") int id, Model model) {
	
			Payee bean = dao.editPayee(id);
			model.addAttribute("user", bean);
			return "EditPayee";

		}

		@PostMapping("/updatepayee")
		public String updateexpense(Payee user, Model model) {
			model.addAttribute(dao.updatePayee(user));	
			List<Payee> list = dao.getPayee();
			model.addAttribute("payee", list);
			return "addPayee";

		}
		

		@GetMapping("/deletepayee/{id}")
		public String deletepayee(@PathVariable("id") int id, Model model) {

			boolean flag = dao.deletePayeeById(id);
			return "redirect:/payee";

		}

//--------------------add,edit,update,delete category--------------------------------
		@RequestMapping(value = "/category", method = RequestMethod.GET)
		public String category(Model model) {
			System.out.println(" category Calling");
			List<Payee> list = dao.getPayee();
			model.addAttribute("payee", list);
			List<category> list1 = dao.getCategory();
			model.addAttribute("category", list1);
			return "addCategory";
		}

		@RequestMapping(value = "/addCategory", method = RequestMethod.POST)
		public String addCategory(@Valid @ModelAttribute("user") category user, BindingResult result,
				@RequestParam("id") int id, Model model) {
			System.out.println(id);
			dao.saveCategory(user, id);
			return "redirect:/category";
		}
		
		@GetMapping("/editcategory/{id}")
		public String editBycategoryId(@PathVariable("id") int id, Model model) {
			List<Payee> list = dao.getPayee();
			model.addAttribute("payee", list);
			category bean = dao.editCategory(id);
			model.addAttribute("user", bean);
			return "EditCategory";

		}

		@PostMapping("/updatecategory")
		public String updatecategory(category user, Model model) {
			model.addAttribute(dao.updateCategory(user));	
			System.out.println("update" );		
			return "redirect:/category";

		}
		
		@GetMapping("/deletecategory/{id}")
		public String deletecategory(@PathVariable("id") int id, Model model) {

			boolean flag = dao.deleteCategoryById(id);
			return "redirect:/category";

		}
		
//---------------------add,edit,update,delete subcategory---------------------------------		
		@RequestMapping(value = "/subcategory", method = RequestMethod.GET)
		public String subcategory(Model model) {
			System.out.println("sub category Calling");
			// model.addAttribute("user", new UserBean());
			List<category> list1 = dao.getCategory();
			model.addAttribute("category", list1);
			List<subCategory> list = dao.getsubCategory();
			model.addAttribute("sub", list);
			return "addSub";
		}

		@RequestMapping(value = "/addSub", method = RequestMethod.POST)
		public String addCategory(@Valid @ModelAttribute("user") subCategory user, BindingResult result,
				@RequestParam("id") int id, Model model) {
			dao.savesubCategory(user, id);
			return "redirect:/subcategory";
		}
		
		@GetMapping("/editsubcategory/{id}")
		public String editBysubcategoryId(@PathVariable("id") int id, Model model) {
			List<category> list1 = dao.getCategory();
			model.addAttribute("category", list1);
			List<subCategory> list = dao.getsubCategory();
			model.addAttribute("sub", list);
			subCategory bean = dao.editSubCategory(id);
			model.addAttribute("user", bean);
			return "EditSub";

		}

		@PostMapping("/updatesubcategory")
		public String updatesubcategory(subCategory user, Model model) {
			model.addAttribute(dao.updateSubCategory(user));		
			return "redirect:/subcategory";

		}
		
		@GetMapping("/deletesubcategory/{id}")
		public String deletesubcategory(@PathVariable("id") int id, Model model) {

			boolean flag = dao.deleteSubCategoryById(id);
			return "redirect:/subcategory";

		}
		
		@RequestMapping(value = "/viewaPdf", method = RequestMethod.GET)
		public String viewadminPdf(Model model) {
			System.out.println("view pdf");
			List<expenses> result = dao.getAllExpense();
			model.addAttribute("expenseDetails", result);
			return "generateapdf";
		}
		
		
}

