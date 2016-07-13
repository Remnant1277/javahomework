package dbutils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Date;

public class JdbcTest {

	    public void insert(String sql){
	        Connection conn = null;
	        PreparedStatement st = null;
	        ResultSet rs = null;
	        try{
	            //获取一个数据库连接
	            conn = JdbcUtils.getConnection();
	            //要执行的SQL命令，SQL中的参数使用?作为占位符
	
	            //通过conn对象获取负责执行SQL命令的prepareStatement对象
	            st = conn.prepareStatement(sql);
	            //为SQL语句中的参数赋值，注意，索引是从1开始的
	        
	            st.setInt(1, 10);//id是int类型的
	            st.setString(2, "suxrui");//name是varchar(字符串类型)
	            st.setString(3, "123");//password是varchar(字符串类型)
	            st.setString(4, "bhsh@sina.com");//email是varchar(字符串类型)
	            st.setDate(5, new java.sql.Date(new Date().getTime()));//birthday是date类型
	            //执行插入操作，executeUpdate方法返回成功的条数
	            int num = st.executeUpdate();
	            if(num>0){
	                System.out.println("插入成功！！");
	            }
	            
	        }catch (Exception e) {
	            e.printStackTrace();
	        }finally{
	            //SQL执行完成之后释放相关资源
	            JdbcUtils.release(conn, st, rs);
	        }
	    }
	    

	    public void delete(String sql){
	        Connection conn = null;
	        PreparedStatement st = null;
	        ResultSet rs = null;
	        try{
	            conn = JdbcUtils.getConnection();
	            st = conn.prepareStatement(sql);
	            st.setInt(1, 1);
	            int num = st.executeUpdate();
	            if(num>0){
	                System.out.println("删除成功！！");
	            }
	        }catch (Exception e) {
	            e.printStackTrace();
	        }finally{
	            JdbcUtils.release(conn, st, rs);
	        }
	    }

	    public void update(String sql){
	        Connection conn = null;
	        PreparedStatement st = null;
	        ResultSet rs = null;
	        try{
	            conn = JdbcUtils.getConnection();
	            st = conn.prepareStatement(sql);
	            st.setString(1, "trst");
	            st.setString(2, "sffl@sina.com");
	            st.setInt(3, 2);
	            int num = st.executeUpdate();
	            if(num>0){
	                System.out.println("更新成功！！");
	            }
	        }catch (Exception e) {
	            e.printStackTrace();
	            
	        }finally{
	            JdbcUtils.release(conn, st, rs);
	        }
	    }
	    
	
	    public void find(String sql){
	        Connection conn = null;
	        PreparedStatement st = null;
	        ResultSet rs = null;
	        try{
	            conn = JdbcUtils.getConnection();
	            st = conn.prepareStatement(sql);
	            st.setInt(1, 1);
	            rs = st.executeQuery();
	            if(rs.next()){
	                System.out.println(rs.getString("name"));
	            }
	        }catch (Exception e) {
	            
	        }finally{
	            JdbcUtils.release(conn, st, rs);
	        }
	    }
	public static void main(String[] args) {
		String sql = "insert into users(id,name,password,email,birthday) values(?,?,?,?,?)";
		JdbcTest test=new JdbcTest();
		test.insert(sql);
	}
}
