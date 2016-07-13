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
	            //��ȡһ�����ݿ�����
	            conn = JdbcUtils.getConnection();
	            //Ҫִ�е�SQL���SQL�еĲ���ʹ��?��Ϊռλ��
	
	            //ͨ��conn�����ȡ����ִ��SQL�����prepareStatement����
	            st = conn.prepareStatement(sql);
	            //ΪSQL����еĲ�����ֵ��ע�⣬�����Ǵ�1��ʼ��
	        
	            st.setInt(1, 10);//id��int���͵�
	            st.setString(2, "suxrui");//name��varchar(�ַ�������)
	            st.setString(3, "123");//password��varchar(�ַ�������)
	            st.setString(4, "bhsh@sina.com");//email��varchar(�ַ�������)
	            st.setDate(5, new java.sql.Date(new Date().getTime()));//birthday��date����
	            //ִ�в��������executeUpdate�������سɹ�������
	            int num = st.executeUpdate();
	            if(num>0){
	                System.out.println("����ɹ�����");
	            }
	            
	        }catch (Exception e) {
	            e.printStackTrace();
	        }finally{
	            //SQLִ�����֮���ͷ������Դ
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
	                System.out.println("ɾ���ɹ�����");
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
	                System.out.println("���³ɹ�����");
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
