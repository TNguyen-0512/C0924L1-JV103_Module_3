package com.example.bai_tap_2.controller;

import com.example.bai_tap_2.model.Client;
import com.example.bai_tap_2.repository.ClientRepository;
import com.example.bai_tap_2.repository.IClientRepository;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name="ClientServlet",value = "/clients")
public class ClientServlet extends HttpServlet {
    private IClientRepository clientRepository = new ClientRepository();
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Client> clients = clientRepository.findAll();
        request.setAttribute("clients", clients);
        request.getRequestDispatcher("/views/client/list.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
