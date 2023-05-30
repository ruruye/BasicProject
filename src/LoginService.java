
public class LoginService {
    private final LoginDAO dao = new LoginDAO();
    
    public CustomerVO login(CustomerVO vo, boolean type) throws Exception {
    	if (type) {// true이면 고객이 로그인하도록
    		return dao.getLogin(vo); 
		} else { // false이면 회사가 로그인 하도록
			return dao.getComLogin(vo); 
		}
    }
}