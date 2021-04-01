package ui.Controller;

import Domain.model.DomainException;
import Domain.model.Woord;
import Domain.model.Woordenlijst;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

@WebServlet("/Controller")
public class Controller extends HttpServlet {
    Woordenlijst woordenlijst = new Woordenlijst();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    private void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String destination;
        String command = request.getParameter("command");
        if (command == null) command = "home";
        switch (command) {
            case "overview":
                destination = showOverview(request);
                break;
            case "add":
                destination = add(request);
                break;
            case "deleteConfirmation":
                destination = "deleteConfirmation.jsp";
                break;
            case "delete":
                destination = delete(request);
                break;
            case "pageAdd":
                destination = "add.jsp";
                break;
            case "pageZoek":
                destination = "zoek.jsp";
                break;
            case "download":
                destination = download(request,response);
                break;
            default:
                destination = goHome(request);
        }
        request.getRequestDispatcher(destination).forward(request, response);
    }

    private String download(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String filename = "woorden.txt";
        response.setContentType("APPLICATION/OCTET-STREAM");
        response.setHeader("Content-Disposition", "attachment; filename=\"" + filename +
                "\""); PrintWriter out = response.getWriter();
        for (Woord woord : woordenlijst.getAlle())
            out.println(woord.getWoord());
        out.close();
        return showOverview(request);
    }

    private String delete(HttpServletRequest request) {
        String woord = request.getParameter("woord");
        woordenlijst.verwijder(woord);
        return showOverview(request);
    }

    private String goHome(HttpServletRequest request) {
        request.setAttribute("aantalWoorden", woordenlijst.getAantalWoorden());
        request.setAttribute("langsteWoord", woordenlijst.getLangsteWoord());
        request.setAttribute("kortsteWoord",woordenlijst.getKortsteWoord());
        request.setAttribute("gemiddelde",woordenlijst.getGemiddeldeVerschillendeLettersVanAlleWoorden());
        request.setAttribute("woordenlijst", woordenlijst.getAlle());
        return "index.jsp";
    }

    private String add(HttpServletRequest request) {
        ArrayList<String> errors = new ArrayList<String>();

        Woord woord = new Woord();
        setWoord(woord,request,errors);
        setLevel(woord,request,errors);


        if(errors.size() == 0){
            try {
                woordenlijst.voegToe(woord);
                return showOverview(request);
            } catch (IllegalArgumentException exc) {
                request.setAttribute("errors",exc.getMessage());
                return "add.jsp";
            }
        } else{
            request.setAttribute("errors",errors);
            return "add.jsp";
        }
    }

    private void setWoord(Woord woord, HttpServletRequest request, ArrayList<String> errors) {
        String woordParameter = request.getParameter("woord");
        try {
            woord.setWoord(woordParameter);
            request.setAttribute("woordClass","has-success");
            request.setAttribute("woordPreviousValue", woordParameter);
        } catch (DomainException exc){
            errors.add(exc.getMessage());
            request.setAttribute("woordClass","has-error");
        }
    }

    private void setLevel(Woord woord, HttpServletRequest request, ArrayList<String> errors) {
        String levelParameter = request.getParameter("niveau");
            try {
                woord.setNiveau(levelParameter);
                request.setAttribute("niveauClass","has-success");
                request.setAttribute("niveauPreviousValue", levelParameter);
            } catch (DomainException exc){
                errors.add(exc.getMessage());
                request.setAttribute("niveauClass","has-error");
            }

    }

    private String showOverview(HttpServletRequest request) {
        request.setAttribute("woorden", woordenlijst.getAlle());
        return "overview.jsp";
    }

}
