import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TestDBConnection {
    public static void main(String[] args) {
        // 1. 数据库连接信息（改成你自己的）
        String url = "jdbc:mysql://localhost:3306/user_db?useSSL=false&serverTimezone=Asia/Shanghai&characterEncoding=utf8&allowPublicKeyRetrieval=true";
        String user = "root";   // 比如 root
        String password = "root1234"; // 比如 123456

        Connection conn = null;
        try {
            // 2. 加载驱动（MySQL 8.0 以上用这个）
            Class.forName("com.mysql.cj.jdbc.Driver");

            // 3. 建立连接
            conn = DriverManager.getConnection(url, user, password);
            System.out.println("✅ 数据库连接成功！");

        } catch (ClassNotFoundException e) {
            System.out.println("❌ 找不到驱动类，请检查 jar 包");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("❌ 连接失败，请检查地址/用户名/密码");
            e.printStackTrace();
        } finally {
            // 4. 关闭连接
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}