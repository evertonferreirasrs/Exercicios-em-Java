package calculadora.controler;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DividirServlet extends HttpServlet {
    
    private final String operacao = "Dividir";
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setAttribute("operacao", operacao);
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/views/Formulario.jsp");
        dispatcher.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Double n1 = Double.parseDouble(request.getParameter("n1"));
        Double n2 = Double.parseDouble(request.getParameter("n2"));
        Double resultado = n1 / n2;
        request.setAttribute("resultado", resultado);
        request.setAttribute("n1", n1);
        request.setAttribute("n2", n2);
        request.setAttribute("operacao", operacao);
        
        List<String> calculoList = (List<String>) request.getSession().getAttribute("calculoList");
        if (calculoList == null){
            calculoList = new ArrayList<>();
            request.getSession().setAttribute("calculoList", calculoList);
        }
        calculoList.add(0, n1+" / "+n2+" = "+ resultado);
        
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/views/Formulario.jsp");
        dispatcher.forward(request, response);
    }

}
