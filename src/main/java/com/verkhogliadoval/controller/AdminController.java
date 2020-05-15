package com.verkhogliadoval.controller;

import com.verkhogliadoval.entity.*;
import com.verkhogliadoval.repository.DoctorRepository;
import com.verkhogliadoval.repository.SpecializationRepository;
import com.verkhogliadoval.repository.TimetableRepository;
import com.verkhogliadoval.repository.VisitRepository;
import com.verkhogliadoval.service.DoctorAdminService;
import com.verkhogliadoval.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;
import java.time.DayOfWeek;

@Controller
public class AdminController {
    @Autowired
    private UserService userService;
    @Autowired
    DoctorRepository doctorRepository;

    @Autowired
    SpecializationRepository specializationRepository;

    @Autowired
    private DoctorAdminService doctorAdminService;

    @Autowired
    TimetableRepository timetableRepository;
    @Autowired
    VisitRepository visitRepository;

    @GetMapping("/admin")
    public String userList(Model model) {
       // model.addAttribute("allUsers", userService.allUsers());
        model.addAttribute("allUsers",userService.usergtList2());
        return "admin";
    }

    @PostMapping("/admin")
    public String deleteUser(@RequestParam(required = true, defaultValue = "") Long userId,
                             @RequestParam(required = true, defaultValue = "") String action,
                             Model model) {
        if (action.equals("delete")) {
            userService.deleteUser(userId);
        }
        return "redirect:/admin";
    }


    @GetMapping("/admin-manage-doctor")
    public String gtDoctor(Model model){
        model.addAttribute("allDoctors",doctorAdminService.findAll());
        return "admin-manage-doctor";
    }

    @PostMapping("/admin-manage-doctor")
    public String deleteDoctor(Model model,@RequestParam(required = true, defaultValue = "") String action,
                               @RequestParam(required = true, defaultValue = "") Long doctorId){
        if (action.equals("delete")) {
            doctorAdminService.deleteDoctor(doctorId);
        }
        return "redirect:/admin-manage-doctor";
    }

    @GetMapping("/add-doctor")
    public String createDoctorForm(Model model) {
        List<Specialization> specialization = doctorAdminService.findAllSpecialization();
        model.addAttribute("specialization", specialization);
        model.addAttribute("doctorForm", new Doctor());
        return "add-doctor";
    }

    @PostMapping("/add-doctor")
    public String createDoctor(@ModelAttribute("doctorForm") @Valid Doctor doctor, HttpServletRequest request, BindingResult result, Model model, @RequestParam("specialization.specializationName") String spec) {
        if (result.hasErrors()) {
            return "add-doctor";
        }
        if(doctor.getFirstName().matches("[0-9]+") || doctor.getLastName().matches("[0-9]+")){
            model.addAttribute("doctornameError","Please provide name,which conatins only characters,not id");
            List<Specialization> specialization = doctorAdminService.findAllSpecialization();
            model.addAttribute("specialization", specialization);
            return "add-doctor";
        }
        if (doctorAdminService.checkIfDoctorExists(doctor)){
            model.addAttribute("doctornameError","Doctor already exists");
            List<Specialization> specialization = doctorAdminService.findAllSpecialization();
            model.addAttribute("specialization", specialization);
            return "add-doctor";
        }
        model.addAttribute("firstName", doctor.getFirstName());
        model.addAttribute("lastName", doctor.getLastName());
        Specialization specialization = specializationRepository.findSpecializationBySpecializationNameEquals(spec).get(0);
        model.addAttribute("specialization", specialization);
        doctorAdminService.saveDoctorWithParameters(doctor.getFirstName(), doctor.getLastName(), specialization);
        return "redirect:/";
    }

    @GetMapping("/add-shift")
    public String createShift(Model model) {
        List<Doctor> shiftDoctors = doctorAdminService.findAll();
        model.addAttribute("shiftForm", new TimeTable());
        model.addAttribute("shiftDoctors", shiftDoctors);
        return "add-shift";
    }

    @InitBinder
    public void initBinder(WebDataBinder webDataBinder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm");
        dateFormat.setLenient(false);
        webDataBinder.registerCustomEditor(LocalDateTime.class, new CustomDateEditor(dateFormat, true));
    }



    @PostMapping("/add-shift")
    public String createShiftForm(@ModelAttribute("shiftForm") @Valid TimeTable timeTable, BindingResult result, Model model, @RequestParam("doctor.doctorId") String doctorFullname,
                                  @RequestParam("dayOfWeek") String dayOfWeek, @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.TIME) LocalTime shiftStart,
                                  @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.TIME) LocalTime shiftEnd) {

        int doctorid = Integer.parseInt(doctorFullname);
        int idDayOFWeek = Integer.parseInt(dayOfWeek);
        Doctor doctorr = doctorRepository.findByDoctorId(doctorid).get(0);
        if (result.hasErrors()) {
            List<Doctor> shiftDoctors = doctorAdminService.findAll();
            model.addAttribute("shiftForm", new TimeTable());
            model.addAttribute("shiftDoctors", shiftDoctors);
            return "/add-shift";
        }

        if(timetableRepository.findAllByDayOfWeekAndShiftStartAndShiftEndAndDoctor(idDayOFWeek,shiftStart,shiftEnd,doctorr).size() != 0){
            model.addAttribute("timeError","Shift already exists");
            List<Doctor> shiftDoctors = doctorAdminService.findAll();
            model.addAttribute("shiftForm", new TimeTable());
            model.addAttribute("shiftDoctors", shiftDoctors);
            return "/add-shift";
        }
        model.addAttribute("doctor", doctorr);
        model.addAttribute("dayOfWeek", idDayOFWeek);
        model.addAttribute("shiftStart", shiftStart);
        model.addAttribute("shiftEnd", shiftEnd);
        doctorAdminService.saveTimetable(doctorr, idDayOFWeek, shiftStart, shiftEnd);
        return "redirect:/";
    }

    @GetMapping("/add-visit")
    public String createVisit(Model model) {
        List <Specialization> specializations = doctorAdminService.findAllSpecialization();
        List<Doctor> doctor = doctorAdminService.findAll();
        model.addAttribute("visitForm", new Visit());
        model.addAttribute("specializations", specializations);
        model.addAttribute("doctor", doctor);
        return "add-visit";
    }


    @PostMapping("/add-visit")
    public String createVisitForm(@ModelAttribute("visitForm") @Valid Visit visit, BindingResult result, Model model, HttpSession session, @RequestParam("specialization.specializationId") String specializationId,
                                  @RequestParam("doctor.doctorId") String doctorId,
                                  @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate visitDate,
                                  @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.TIME) LocalTime visitTime ) {
        {
            if (result.hasErrors()) {
                return "/add-visit";
            }
            DayOfWeek dayWeek = visitDate.getDayOfWeek();
            int dayOfWeekVisitValue = dayWeek.getValue();
            long specID = Long.parseLong(specializationId);
            int doctorid = Integer.parseInt(doctorId);
            Specialization specialization = specializationRepository.findBySpecializationId(specID).get(0);
            User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
             Doctor doctor = doctorRepository.findByDoctorId(doctorid).get(0);
             if(visitRepository.findByDoctorAndUserAndVisitDateAndVisitTime(visitDate,visitTime,doctor,user) != null){
                 model.addAttribute("visitError","Visit already exists");
             }
        if(timetableRepository.findAllByDoctor(doctor).getShiftStart().isAfter(visitTime) || !timetableRepository.findAllByDoctor(doctor).getShiftStart().equals(visitTime) ||  timetableRepository.findAllByDoctor(doctor).getShiftEnd().isBefore(visitTime) || timetableRepository.findAllByDoctor(doctor).getDayOfWeek()!= dayOfWeekVisitValue){
            model.addAttribute("visitError", "Sorry, doctor doesn`t work at those days/time, please try to provide another time/date");
        }

             model.addAttribute("user",user);
            model.addAttribute("doctor",doctor);
            model.addAttribute("specialization",specialization);
            model.addAttribute("visitDate",visitDate);
            model.addAttribute("visitTime",visitTime);
            doctorAdminService.saveVisit(doctor,specialization,visitDate,visitTime,user);
            return "redirect:/";
        }

    }
}
