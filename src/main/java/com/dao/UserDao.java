package com.dao;

import java.sql.ResultSet;

import java.sql.SQLException;
import java.sql.Date;
import java.util.List;
import java.sql.Time;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.bean.Account;
import com.bean.AccountType;
import com.bean.BalanceBean;
import com.bean.Payee;
import com.bean.RoleBean;
import com.bean.UserBean;
import com.bean.category;
import com.bean.expenses;
import com.bean.subCategory;
import com.dao.UserDao.UserRowMapper;

@Repository
public class UserDao {
	@Autowired
	JdbcTemplate stmt;

	public void saveUser(UserBean user) {
		stmt.update("insert into REGISTER (firstname,email,pass,role_id,profile) values (?,?,?,2,?)",
				user.getFirstName(), user.getEmail(), user.getPassword(), user.getFilepath());

	}

	public List<UserBean> getUsers() {

		List<UserBean> users = stmt.query("select * from REGISTER", new UserRowMapper());
		return users;
	}

	class UserRowMapper implements RowMapper<UserBean> {

		public UserBean mapRow(ResultSet rs, int rowNum) throws SQLException {

			UserBean user = new UserBean();
			user.setUserId(rs.getInt("id"));
			user.setFirstName(rs.getString("firstName"));
			user.setEmail(rs.getString("email"));
			user.setPassword(rs.getString("pass"));
			return user;
		}
	}

	public List<UserBean> viewProfile(int id) {

		List<UserBean> users = stmt.query("select * from REGISTER where id=" + id, new UserRowMapper9());
		return users;
	}

	class UserRowMapper9 implements RowMapper<UserBean> {

		public UserBean mapRow(ResultSet rs, int rowNum) throws SQLException {

			UserBean user = new UserBean();
			user.setUserId(rs.getInt("id"));
			user.setFirstName(rs.getString("firstName"));
			user.setEmail(rs.getString("email"));
			user.setPassword(rs.getString("pass"));
			return user;
		}
	}

	public List<AccountType> getTypes() {

		List<AccountType> users = stmt.query("select * from ACCOUNT_TYPE", new UserRowMapper1());
		return users;
	}

	class UserRowMapper1 implements RowMapper<AccountType> {

		public AccountType mapRow(ResultSet rs, int rowNum) throws SQLException {

			AccountType user = new AccountType();
			user.setAt_id(rs.getInt("at_id"));
			user.setType(rs.getString("type"));

			return user;
		}
	}
	
	public List<AccountType> getTypesByUser(int id) {

		List<AccountType> users = stmt.query("select * from ACCOUNT_TYPE join account on ACCOUNT_TYPE.at_id=account.at_id where id="+id, new UserRowMapper20());
		return users;
	}

	class UserRowMapper20 implements RowMapper<AccountType> {

		public AccountType mapRow(ResultSet rs, int rowNum) throws SQLException {

			AccountType user = new AccountType();
			user.setAt_id(rs.getInt("at_id"));
			user.setType(rs.getString("type"));

			return user;
		}
	}

	public List<RoleBean> getRoles() {

		List<RoleBean> users = stmt.query("select * from ROLE_TABLE", new UserRowMapper3());
		System.out.println(users);
		return users;
	}

	class UserRowMapper3 implements RowMapper<RoleBean> {

		public RoleBean mapRow(ResultSet rs, int rowNum) throws SQLException {

			RoleBean user = new RoleBean();
			user.setRoleId(rs.getInt("role_id"));
			user.setRoleName(rs.getString("role_user"));

			return user;
		}
	}

	public List<Payee> getPayee() {

		List<Payee> users = stmt.query("select * from payee", new UserRowMapper5());
		System.out.println(users);
		return users;

	}

	class UserRowMapper5 implements RowMapper<Payee> {

		public Payee mapRow(ResultSet rs, int rowNum) throws SQLException {

			Payee user = new Payee();
			user.setPid(rs.getInt("pid"));
			user.setPname(rs.getString("pname"));

			return user;
		}
	}

	public List<category> getCategory() {

		List<category> users = stmt.query("select * from category join payee on category.pid=payee.pid ",
				new UserRowMapper6());
		System.out.println(users);
		return users;

	}

	class UserRowMapper6 implements RowMapper<category> {

		public category mapRow(ResultSet rs, int rowNum) throws SQLException {

			category user = new category();
			Payee pay = new Payee();
			user.setCid(rs.getInt("cid"));
			user.setCname(rs.getString("cname"));
			pay.setPid(rs.getInt("pid"));
			pay.setPname(rs.getString("pname"));
			user.setPname(pay);
			return user;
		}
	}

	public List<subCategory> getsubCategory() {

		List<subCategory> users = stmt.query("select * from subCategory join category on subCategory.cid=category.cid ",
				new UserRowMapper7());
		System.out.println(users);
		return users;

	}

	class UserRowMapper7 implements RowMapper<subCategory> {

		public subCategory mapRow(ResultSet rs, int rowNum) throws SQLException {

			subCategory user = new subCategory();
			category user1 = new category();
			user.setSid(rs.getInt("sid"));
			user.setSname(rs.getString("sname"));
			user1.setCid(rs.getInt("cid"));
			user1.setCname(rs.getString("cname"));
			user.setCname(user1);
			return user;
		}
	}

	public List<Account> getAccount(int id) {

		List<Account> users = stmt.query(
				"select * from ACCOUNT join ACCOUNT_TYPE on ACCOUNT.at_id=ACCOUNT_TYPE.at_id where id=" + id,
				new UserRowMapper2());
		System.out.println(users);
		return users;

	}

	class UserRowMapper2 implements RowMapper<Account> {

		public Account mapRow(ResultSet rs, int rowNum) throws SQLException {

			Account user = new Account();
			AccountType type = new AccountType();
			user.setA_id(rs.getInt("a_id"));
			user.setAname(rs.getString("account_name"));
			user.setBalance(rs.getString("balance"));
			user.setCurrentDate(rs.getDate("cdate"));
			user.setCurrentTime(rs.getTime("time1"));
			type.setAt_id(rs.getInt("at_id"));
			type.setType(rs.getString("type"));
			user.setType(type);
			return user;
		}
	}

	public void addAccount(Account bean, int id) {

		bean.setA_id(id);
		Date d = new Date(System.currentTimeMillis());
		bean.setCurrentDate(d);
		Time t = new Time(System.currentTimeMillis());
		bean.setCurrentTime(t);
		stmt.update("insert into Account (account_name,balance,id,at_id,cdate,time1) values (?,?,?,?,?,?)",
				bean.getAname(), bean.getBalance(), bean.getId(), bean.getA_id(), bean.getCurrentDate(),
				bean.getCurrentTime());

	}

	public void saveRole(RoleBean user) {
		stmt.update("insert into ROLE_TABLE (role_user) values (?)", user.getRoleName());
	}

	public void saveType(AccountType user) {
		stmt.update("insert into ACCOUNT_TYPE (type) values (?)", user.getType());

	}

	public void savePayee(Payee user) {
		stmt.update("insert into payee (pname) values (?)", user.getPname());

	}

	public void saveCategory(category user, int id) {
		user.setCid(id);
		stmt.update("insert into category (cname,pid) values (?,?)", user.getCname(), user.getCid());

	}

	public void savesubCategory(subCategory user, int id) {
		user.setSid(id);
		stmt.update("insert into subCategory (sname,cid) values (?,?)", user.getSname(), user.getSid());

	}

	public UserBean editById(int id) {
		String sql = "select * from REGISTER where id=" + id;
		return stmt.query(sql, new ResultSetExtractor<UserBean>() {
			public UserBean extractData(ResultSet rs) throws SQLException, DataAccessException {
				if (rs.next()) {
					UserBean user = new UserBean();
					user.setUserId(rs.getInt("id"));
					user.setFirstName(rs.getString("firstname"));
					user.setEmail(rs.getString("email"));
					user.setPassword(rs.getString("pass"));
					return user;
				}
				return null;
			}
		});
	}

	public UserBean forget(UserBean bean) {
		System.out.println("in dao forget");
		String email = bean.getEmail();
		String sql = "select * from REGISTER where email='" + email + "'";
		return stmt.query(sql, new ResultSetExtractor<UserBean>() {
			public UserBean extractData(ResultSet rs) throws SQLException, DataAccessException {
				if (rs.next()) {
					UserBean user = new UserBean();
					user.setEmail(rs.getString("email"));
					return user;
				}
				return null;
			}
		});
	}

	public boolean update(UserBean bean) {
		String sql = "update REGISTER set firstname='" + bean.getFirstName() + "',email='" + bean.getEmail()
				+ "',pass='" + bean.getPassword() + "'where id='" + bean.getUserId() + "'";
		stmt.update(sql);
		return false;
	}

	public boolean delUser(int userId) {
		stmt.update("delete from REGISTER where id =?", userId);
		return false;
	}

	public UserBean getUsers1(UserBean bean) {
		String email = bean.getEmail();
		String pass = bean.getPassword();
		String sql = "select * from REGISTER join ROLE_TABLE on REGISTER.role_id=ROLE_TABLE.role_id where email='"
				+ email + "' and pass='" + pass + "'";
		return stmt.query(sql, new ResultSetExtractor<UserBean>() {
			public UserBean extractData(ResultSet rs) throws SQLException, DataAccessException {
				if (rs.next()) {
					UserBean user = new UserBean();
					RoleBean r = new RoleBean();
					user.setUserId(rs.getInt("id"));
					user.setFirstName(rs.getString("firstname"));
					user.setEmail(rs.getString("email"));
					user.setPassword(rs.getString("pass"));
					r.setRoleId(rs.getInt("role_id"));
					r.setRoleName(rs.getString("role_user"));
					user.setRoleName(r);
					;
					return user;
				}
				return null;
			}
		});

	}

	public List<expenses> getAllExpenseDetails(int userID) {
		String query = "select * from expense join account_type on expense.at_id=account_type.at_id where expense.id="
				+ userID;

		return stmt.query(query, new RowMapper<expenses>() {
			public expenses mapRow(ResultSet rs, int rowNum) throws SQLException {
				expenses expensebean = new expenses();
				AccountType account = new AccountType();
				expensebean.setExpenseId(rs.getInt("expenseId"));
				expensebean.setPayeeName(rs.getString("payee"));
				expensebean.setAmmount(rs.getInt("amount"));
				expensebean.setTimeexp(rs.getTime("timeExp"));
				expensebean.setDateexp(rs.getDate("dateExp"));
				expensebean.setDescription(rs.getString("description"));
				account.setAt_id(rs.getInt("at_id"));
				account.setType(rs.getString("type"));
				expensebean.setType(account);
				expensebean.setCategorydatalist(rs.getString("category"));
				expensebean.setSubcategorydatalist(rs.getString("subcategory"));
				expensebean.setImage(rs.getString("exppic"));

				if (getallCategoryByPayeeName(expensebean.getPayeeName()).isEmpty()) {
					updateCategoryByPayeeName(expensebean.getCategorydatalist(), expensebean.getPayeeName());
				}
				if (getallsubCategoryByCategoryName(expensebean.getCategorydatalist()).isEmpty()) {
					updatesubCategoryBycategory(expensebean.getSubcategorydatalist(),
							expensebean.getCategorydatalist());
				}

				return expensebean;
			}
		});

	}

	public List<expenses> getAllExpenseDetailsByMonth(int userID, int month) {
		String query = "select * from expense join account_type on expense.at_id=account_type.at_id where expense.id="
				+ userID + "and month(dateExp)=" + month + "";
		return stmt.query(query, new RowMapper<expenses>() {
			public expenses mapRow(ResultSet rs, int rowNum) throws SQLException {
				expenses expensebean = new expenses();
				AccountType account = new AccountType();
				expensebean.setExpenseId(rs.getInt("expenseId"));
				expensebean.setPayeeName(rs.getString("payee"));
				expensebean.setAmmount(rs.getInt("amount"));
				expensebean.setTimeexp(rs.getTime("timeExp"));
				expensebean.setDateexp(rs.getDate("dateExp"));
				expensebean.setDescription(rs.getString("description"));
				account.setAt_id(rs.getInt("at_id"));
				account.setType(rs.getString("type"));
				expensebean.setType(account);
				expensebean.setCategorydatalist(rs.getString("category"));
				expensebean.setSubcategorydatalist(rs.getString("subcategory"));
				expensebean.setImage(rs.getString("exppic"));

				return expensebean;
			}
		});

	}

	public List<expenses> getAllExpenseDetailsByYear(int userID, int year) {
		String query = "select * from expense join account_type on expense.at_id=account_type.at_id where expense.id="
				+ userID + "and year(dateExp)=" + year + "";
		return stmt.query(query, new RowMapper<expenses>() {
			public expenses mapRow(ResultSet rs, int rowNum) throws SQLException {
				expenses expensebean = new expenses();
				AccountType account = new AccountType();
				expensebean.setExpenseId(rs.getInt("expenseId"));
				expensebean.setPayeeName(rs.getString("payee"));
				expensebean.setAmmount(rs.getInt("amount"));
				expensebean.setTimeexp(rs.getTime("timeExp"));
				expensebean.setDateexp(rs.getDate("dateExp"));
				expensebean.setDescription(rs.getString("description"));
				account.setAt_id(rs.getInt("at_id"));
				account.setType(rs.getString("type"));
				expensebean.setType(account);
				expensebean.setCategorydatalist(rs.getString("category"));
				expensebean.setSubcategorydatalist(rs.getString("subcategory"));
				expensebean.setImage(rs.getString("exppic"));
				return expensebean;
			}
		});

	}

	public List<expenses> getAllExpenseDetailsByDate(int userID, Date date1, Date date2) {
		String query = "select * from expense join account_type on expense.at_id=account_type.at_id where expense.id='"
				+ userID + "' and dateExp between '" + date1 + "'  and '" + date2 + "'";
		return stmt.query(query, new RowMapper<expenses>() {
			public expenses mapRow(ResultSet rs, int rowNum) throws SQLException {
				expenses expensebean = new expenses();
				AccountType account = new AccountType();
				expensebean.setExpenseId(rs.getInt("expenseId"));
				expensebean.setPayeeName(rs.getString("payee"));
				expensebean.setAmmount(rs.getInt("amount"));
				expensebean.setTimeexp(rs.getTime("timeExp"));
				expensebean.setDateexp(rs.getDate("dateExp"));
				expensebean.setDescription(rs.getString("description"));
				account.setAt_id(rs.getInt("at_id"));
				account.setType(rs.getString("type"));
				expensebean.setType(account);
				expensebean.setCategorydatalist(rs.getString("category"));
				expensebean.setSubcategorydatalist(rs.getString("subcategory"));
				expensebean.setImage(rs.getString("exppic"));

				return expensebean;
			}
		});

	}

	public UserBean viewUser(int id) {
		String sql = "select * from REGISTER where id=" + id;
		return stmt.query(sql, new ResultSetExtractor<UserBean>() {
			public UserBean extractData(ResultSet rs) throws SQLException, DataAccessException {
				if (rs.next()) {
					UserBean user = new UserBean();
					// user.setUserId(rs.getInt("id"));
					user.setFirstName(rs.getString("firstname"));
					user.setEmail(rs.getString("email"));
					user.setPassword(rs.getString("pass"));
					return user;
				}
				return null;
			}
		});
	}

	public boolean updatePassword(String email, String pass) {
		String sql = "update REGISTER set pass='" + pass + "'where email='" + email + "'";
		stmt.update(sql);
		return false;

	}

	public void updatebalance(expenses expbean) {
		String query = "update account set balance=balance" + -expbean.getAmmount() + " where at_id="
				+ expbean.getUseraccountID() + " and id=" + expbean.getUserId();
		stmt.update(query);

	}
	public void updatebalanceplus(expenses expbean) {
		String query = "update account set balance=balance" + +expbean.getAmmount() + " where at_id="
				+ expbean.getUseraccountID() + " and id=" + expbean.getUserId();
		stmt.update(query);

	}
	/*
	 * public void updateaddbalance(expenses expbean) { String query =
	 * "update account set balance=balance" + -expbean.getAmmount() +
	 * " where at_id=" + expbean.getUseraccountID() + " and id=" +
	 * expbean.getUserId(); stmt.update(query);
	 * 
	 * }
	 */

	public BalanceBean getamountbyuserIDandaccountID(int userID, int useraccountID) {
		String query = "select * from account where id=" + userID + " and at_id=" + useraccountID;
		return stmt.query(query, new ResultSetExtractor<BalanceBean>() {
			public BalanceBean extractData(ResultSet rs) throws SQLException, DataAccessException {
				if (rs.next()) {
					BalanceBean balance = new BalanceBean();
					balance.setAmount(rs.getInt("balance"));

					return balance;
				}
				return null;

			}
		});

	}

	public Account getAccountType1(Account bean) {

		String sql = "select * from ACCOUNT join  ACCOUNT_TYPE on ACCOUNT.at_id=ACCOUNT_TYPE.at_id";
		return stmt.query(sql, new ResultSetExtractor<Account>() {
			public Account extractData(ResultSet rs) throws SQLException, DataAccessException {
				if (rs.next()) {
					Account a = new Account();
					AccountType at = new AccountType();
					a.setA_id(rs.getInt("a_id"));
					a.setAname(rs.getString("aname"));
					a.setBalance(rs.getString("balance"));
					// user.setPassword(rs.getString("pass"));
					at.setAt_id(rs.getInt("at_id"));
					at.setType(rs.getString("type"));
					a.setType(at);
					return a;
				}
				return null;
			}
		});

	}

	public List<category> getallCategoryByPayeeName(String payeeName) {
		String query = "select * from category where pname='" + payeeName + "'";
		return stmt.query(query, new RowMapper<category>() {
			public category mapRow(ResultSet resultSet, int rowNum) throws SQLException {
				category category = new category();
				category.setCid(resultSet.getInt("cid"));
				category.setCname(resultSet.getString("cname"));

				return category;
			}
		});
	}

	public List<String> getallsubCategoryByCategoryName(String categoryName) {
		String query = "select * from Subcategory where cname='" + categoryName + "'";
		return stmt.query(query, new RowMapper<String>() {
			public String mapRow(ResultSet resultSet, int rowNum) throws SQLException {
				return resultSet.getString("sname");
			}
		});
	}

	public void updateCategoryByPayeeName(String categoryName, String payeeName) {
		String query = "insert into category(cname,pname) values(?,?)";

		stmt.update(query, categoryName, payeeName);
	}

	public void updatesubCategoryBycategory(String subcategoryName, String categoryName) {
		String query = "insert into subCategory(sname,cname) values(?,?)";
		stmt.update(query, subcategoryName, categoryName);
	}

	public void setexpense(expenses expbean) {
		System.out.println(expbean.getUserId());
		System.out.println("set>>>>>");
		String query = "insert into expense (payee,amount,at_id,description,id,dateExp,timeExp,exppic,category,subcategory) values (?,?,?,?,?,?,?,?,?,?)";
		stmt.update(query, expbean.getPayeeName(), expbean.getAmmount(), expbean.getUseraccountID(),
				expbean.getDescription(), expbean.getUserId(), expbean.getDateexp(), expbean.getTimeexp(),
				expbean.getImage(), expbean.getCategorydatalist(), expbean.getSubcategorydatalist());

	}

	public void setpayee(String payeeName, int userId) {
		String query = "insert into payee(pname,id) values(?,?)";
		stmt.update(query, payeeName, userId);

	}

	public boolean getUsersaccount(int a_id) {
		stmt.update("delete from ACCOUNT where a_id =?", a_id);
		return false;
	}

	public boolean getUserexpense(int expenseId) {
		stmt.update("delete from expense where expenseId =?", expenseId);
		return false;
	}

	public expenses editByexpenseId(int id) {
		String sql = "select * from expense where expenseId=" + id;
		return stmt.query(sql, new ResultSetExtractor<expenses>() {
			public expenses extractData(ResultSet rs) throws SQLException, DataAccessException {
				if (rs.next()) {
					expenses user = new expenses();
					user.setExpenseId(rs.getInt("expenseId"));
					user.setPayeeName(rs.getString("payee"));
					user.setAmmount(rs.getInt("amount"));
					user.setDateexp(rs.getDate("dateExp"));
					user.setTimeexp(rs.getTime("timeExp"));
					user.setImage(rs.getString("exppic"));
					user.setDescription(rs.getString("description"));
					user.setCategorydatalist(rs.getString("category"));
					user.setSubcategorydatalist(rs.getString("subcategory"));
					return user;
				}
				return null;
			}
		});
	}

	public boolean updateexpense(expenses bean) {
		String sql = "update expense set payee='" + bean.getPayeeName() + "',amount='" + bean.getAmmount()
				+ "',dateExp='" + bean.getDateexp() + "',timeExp='" + bean.getTimeexp() + "',category='"
				+ bean.getCategorydatalist() + "',subcategory='" + bean.getSubcategorydatalist() + "',exppic='"
				+ bean.getImage() + "',description='" + bean.getDescription() + "'where expenseId='"
				+ bean.getExpenseId() + "'";
		stmt.update(sql);
		return false;
	}

	public Account editAccount(int id) {
		{
			String sql = "select a_id,account_name,balance,cdate,time1,ACCOUNT_TYPE.type from account join account_type on account.at_id=account_type.at_id where a_id="
					+ id;
			return stmt.query(sql, new ResultSetExtractor<Account>() {
				public Account extractData(ResultSet rs) throws SQLException, DataAccessException {
					if (rs.next()) {
						Account user = new Account();
						AccountType type = new AccountType();
						user.setA_id(rs.getInt("a_id"));
						user.setAname(rs.getString("account_name"));
						user.setBalance(rs.getString("balance"));
						user.setCurrentDate(rs.getDate("cdate"));
						user.setCurrentTime(rs.getTime("time1"));
						type.setType(rs.getString("type"));
						user.setType(type);

						return user;
					}
					return null;
				}
			});
		}
	}

	public boolean updateAcc(Account bean) {
		String sql = "update ACCOUNT set account_name='" + bean.getAname() + "',  balance='" + bean.getBalance()
				+ "',cdate='" + bean.getCurrentDate() + "',time1='" + bean.getCurrentTime() + "'where a_id='"
				+ bean.getA_id() + "'";
		stmt.update(sql);
		return false;
	}

	public boolean deletePayeeById(int id) {
		String sql = "delete from payee where pid=" + id;
		stmt.update(sql);
		return false;
	}

	public boolean deleteCategoryById(int id) {
		String sql = "delete from category where cid=" + id;
		stmt.update(sql);
		return false;
	}

	public boolean deleteSubCategoryById(int id) {
		String sql = "delete from SubCategory where sid=" + id;
		stmt.update(sql);
		return false;
	}

	public Payee editPayee(int id) {
		{
			String sql = "select * from Payee where pid=" + id;
			return stmt.query(sql, new ResultSetExtractor<Payee>() {
				public Payee extractData(ResultSet rs) throws SQLException, DataAccessException {
					if (rs.next()) {
						Payee user = new Payee();
						user.setPid(rs.getInt("pid"));
						user.setPname(rs.getString("pname"));
						return user;
					}
					return null;
				}
			});
		}
	}

	public boolean updatePayee(Payee bean) {
		String sql = "update Payee set pname='" + bean.getPname() + "'where pid='" + bean.getPid() + "'";
		stmt.update(sql);
		return false;
	}

	public boolean updateCategory(category bean) {
		String sql = "update Category set cname='" + bean.getCname() + "'where cid='" + bean.getCid() + "'";
		stmt.update(sql);
		return false;
	}

	public category editCategory(int id) {
		{
			String sql = "select cid,cname,Payee.pname  from Category join Payee on Category.pid=Payee.pid where cid="
					+ id;
			return stmt.query(sql, new ResultSetExtractor<category>() {
				public category extractData(ResultSet rs) throws SQLException, DataAccessException {
					if (rs.next()) {
						category user = new category();
						Payee pay = new Payee();
						user.setCid(rs.getInt("cid"));
						user.setCname(rs.getString("cname"));
						pay.setPname(rs.getString("pname"));
						user.setPname(pay);
						return user;
					}
					return null;
				}
			});
		}
	}

	public subCategory editSubCategory(int id) {
		{
			String sql = "select sid,sname,Category.cname from SubCategory join Category on SubCategory.cid=Category.cid where sid="
					+ id;
			return stmt.query(sql, new ResultSetExtractor<subCategory>() {
				public subCategory extractData(ResultSet rs) throws SQLException, DataAccessException {
					if (rs.next()) {
						subCategory user = new subCategory();
						category cat = new category();
						user.setSid(rs.getInt("sid"));
						user.setSname(rs.getString("sname"));
						cat.setCname(rs.getString("cname"));
						user.setCname(cat);
						return user;
					}
					return null;
				}
			});
		}
	}

	public boolean updateSubCategory(subCategory bean) {
		String sql = "update SubCategory set sname='" + bean.getSname() + "'where sid='" + bean.getSid() + "'";
		stmt.update(sql);
		return false;
	}

	public boolean checkDuplicateEmail(String email) {

		List<UserBean> users = stmt.query(
				"select * from register,role_table where email like ? and role_table.role_id = register.role_id",
				new UserRowMapper(), email);
		System.out.println(users.size());
		if (users.size() == 0)
			return false;
		else
			return true;
	}

	public List<Payee> userPayee(int id) {

		List<Payee> users = stmt.query("select * from payee where id=" + id, new UserRowMapper10());
		System.out.println(users);
		return users;

	}

	class UserRowMapper10 implements RowMapper<Payee> {

		public Payee mapRow(ResultSet rs, int rowNum) throws SQLException {

			Payee user = new Payee();
			user.setPid(rs.getInt("pid"));
			user.setPname(rs.getString("pname"));

			return user;
		}
	}

	public List<category> userCategory(int id) {

		List<category> users = stmt.query("select * from category  where id=" + id, new UserRowMapper11());
		System.out.println(users);
		return users;

	}

	class UserRowMapper11 implements RowMapper<category> {

		public category mapRow(ResultSet rs, int rowNum) throws SQLException {

			category user = new category();
			Payee pay = new Payee();
			user.setCid(rs.getInt("cid"));
			user.setCname(rs.getString("cname"));
			pay.setPid(rs.getInt("pid"));
			pay.setPname(rs.getString("pname"));
			user.setPname(pay);
			return user;
		}
	}

	public List<subCategory> userSubCategory(int id) {

		List<subCategory> users = stmt.query("select * from subCategory  where id=" + id, new UserRowMapper12());
		System.out.println(users);
		return users;

	}

	class UserRowMapper12 implements RowMapper<subCategory> {

		public subCategory mapRow(ResultSet rs, int rowNum) throws SQLException {

			subCategory user = new subCategory();
			category user1 = new category();
			user.setSid(rs.getInt("sid"));
			user.setSname(rs.getString("sname"));
			user1.setCid(rs.getInt("cid"));
			user1.setCname(rs.getString("cname"));
			user.setCname(user1);
			return user;
		}
	}

	public void saveusubCategory(subCategory user, int id) {
		user.setSid(id);
		stmt.update("insert into subCategory (sname,cid,id) values (?,?,?)", user.getSname(), user.getSid(),user.getId());

	}

	public void saveuCategory(category user, int cid) {
		user.setCid(cid);
		stmt.update("insert into category (cname,pid,id) values (?,?,?)", user.getCname(), user.getCid(), user.getId());

	}

	public void saveuPayee(Payee user) {
		stmt.update("insert into payee (pname,id) values (?,?)", user.getPname(), user.getId());
	}

	public boolean deleteuPayeeById(int id) {
		String sql = "delete from payee where pid=" + id;
		stmt.update(sql);
		return false;
	}

	public boolean deleteuCategoryById(int id) {
		String sql = "delete from category where cid=" + id;
		stmt.update(sql);
		return false;
	}

	public boolean deleteuSubCategoryById(int id) {
		String sql = "delete from SubCategory where sid=" + id;
		stmt.update(sql);
		return false;
	}

	public Payee edituPayee(int id) {
		{
			String sql = "select * from Payee where pid=" + id;
			return stmt.query(sql, new ResultSetExtractor<Payee>() {
				public Payee extractData(ResultSet rs) throws SQLException, DataAccessException {
					if (rs.next()) {
						Payee user = new Payee();
						user.setPid(rs.getInt("pid"));
						user.setPname(rs.getString("pname"));
						user.setId(rs.getInt("id"));
						return user;
					}
					return null;
				}
			});
		}
	}

	public boolean updateuPayee(Payee bean) {
		String sql = "update Payee set pname='" + bean.getPname() + "'where pid='" + bean.getPid() + "'";
		stmt.update(sql);
		return false;
	}

	public category edituCategory(int id) {
		{
			String sql = "select cid,cname,Payee.pname  from Category join Payee on Category.pid=Payee.pid where cid="
					+ id;
			return stmt.query(sql, new ResultSetExtractor<category>() {
				public category extractData(ResultSet rs) throws SQLException, DataAccessException {
					if (rs.next()) {
						category user = new category();
						Payee pay = new Payee();
						user.setCid(rs.getInt("cid"));
						user.setCname(rs.getString("cname"));
						pay.setPname(rs.getString("pname"));
						user.setPname(pay);

						return user;
					}
					return null;
				}
			});
		}
	}

	public boolean updateuCategory(category bean) {
		String sql = "update Category set cname='" + bean.getCname() + "'where cid='" + bean.getCid() + "'";
		stmt.update(sql);
		return false;
	}

	public subCategory edituSubCategory(int id) {
		{
			String sql = "select sid,sname,Category.cname from SubCategory join Category on SubCategory.cid=Category.cid where sid="
					+ id;
			return stmt.query(sql, new ResultSetExtractor<subCategory>() {
				public subCategory extractData(ResultSet rs) throws SQLException, DataAccessException {
					if (rs.next()) {
						subCategory user = new subCategory();
						category cat = new category();
						user.setSid(rs.getInt("sid"));
						user.setSname(rs.getString("sname"));
						cat.setCname(rs.getString("cname"));
						user.setCname(cat);
						return user;
					}
					return null;
				}
			});
		}
	}

	public boolean updateuSubCategory(subCategory bean) {
		String sql = "update SubCategory set sname='" + bean.getSname() + "'where sid='" + bean.getSid() + "'";
		stmt.update(sql);
		return false;
	}

	public List<expenses> getAllExpense() {
		String query = "select * from expense join account_type on expense.at_id=account_type.at_id";

		return stmt.query(query, new RowMapper<expenses>() {
			public expenses mapRow(ResultSet rs, int rowNum) throws SQLException {
				expenses expensebean = new expenses();
				AccountType account = new AccountType();
				expensebean.setExpenseId(rs.getInt("expenseId"));
				expensebean.setPayeeName(rs.getString("payee"));
				expensebean.setAmmount(rs.getInt("amount"));
				expensebean.setTimeexp(rs.getTime("timeExp"));
				expensebean.setDateexp(rs.getDate("dateExp"));
				expensebean.setDescription(rs.getString("description"));
				account.setAt_id(rs.getInt("at_id"));
				account.setType(rs.getString("type"));
				expensebean.setType(account);
				expensebean.setCategorydatalist(rs.getString("category"));
				expensebean.setSubcategorydatalist(rs.getString("subcategory"));
				expensebean.setImage(rs.getString("exppic"));

				return expensebean;
			}
		});

	}

	public boolean delExpense(int userId) {
		stmt.update("delete from expense where expenseId =?", userId);
		return false;
	}

}
