package com.ensa.glminiprojectsp.Controllers.Admin;

import com.ensa.glminiprojectsp.Beans.Professor;
import com.ensa.glminiprojectsp.Controllers.LoginController;
import com.ensa.glminiprojectsp.Factory.Factory;
import com.ensa.glminiprojectsp.Utils.APIGetSet;
import com.ensa.glminiprojectsp.Utils.InputVerifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import jakarta.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Map;


@Controller
public class ManageProfessorsController {
    @GetMapping("/Dashboard/ManageProfessors")
    public String dashboard(HttpSession session, Model model) {

        if(!LoginController.VerifySession(session))
            return "redirect:/login";

        Professor[] professors = APIGetSet.getObject("/api/professors", Professor[].class);
        model.addAttribute("professors", professors);

        return "manage_professors";
    }

    @PostMapping("/Dashboard/ManageProfessors/Delete")
    public String remove(@RequestBody Map<String, List<String>>requestBody) {
        String selectedIds = String.join(",", requestBody.get("selectedIds"));
        if(!selectedIds.isEmpty())
        {
            String api = "/api/professors/delete/" + selectedIds;
            APIGetSet.getObject(api, boolean.class);
        }
        return "redirect:/Dashboard/ManageProfessors";
    }

    @PostMapping("/Dashboard/ManageProfessors/Add")
    public String add(@RequestBody Map<String, String> requestBody) {
        String id = requestBody.get("id");
        String firstName = requestBody.get("firstName");
        String lastName = requestBody.get("lastName");
        String specialty = requestBody.get("specialty");
        if (    InputVerifier.checkInput(id, InputVerifier.FLAGS.NO_SPECIAL)
                && InputVerifier.checkInput(firstName)
                && InputVerifier.checkInput(lastName)
                && InputVerifier.checkInput(specialty)  )
        {
            Professor prof = (Professor)Factory.makePerson("P", id, firstName, lastName);
            prof.setSpecialty(specialty);
            APIGetSet.sendObject("/api/professors/add/", prof);
        }

        return "redirect:/Dashboard/ManageProfessors";
    }
}
