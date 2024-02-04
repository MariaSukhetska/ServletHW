import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/calculate")
public class CalculatorServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String operation = req.getParameter("op");
        double num1 = Double.parseDouble(req.getParameter("n1"));
        double num2 = Double.parseDouble(req.getParameter("n2"));

        if (operation.equals("divide") && num2 == 0) {
            resp.getWriter().println("Error: " + "Division by zero isn't possible!");

        }

        double result = switch (operation) {
            case "add" -> num1 + num2;
            case "subtract" -> num1 - num2;
            case "multiply" -> num1 * num2;
            case "divide" -> num1 / num2;
            default -> {
                resp.getWriter().println("Unknown operation");
                yield 0.0;
            }
        };

        resp.getWriter().println("Operation = " + operation);
        resp.getWriter().println("Result = " + result);
    }
}
