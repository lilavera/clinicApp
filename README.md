# clinicApp
Application for Clinic: 

- managed by admin(add doctors,add shifts,delete patients,delete doctors)
- users can sign up,log in and choose visit for the doctor


# Technologies:
BackEnd:
- SpringBoot
- SpringSecurity
- Hibernate
- PostgreSQL
- JSP


FrontEnd:
- Bootstap/Pingendo


*NOTE*
After launching app for the first time add roles to database:
INSERT INTO public.t_role(id, name)
  VALUES (1, 'ROLE_USER'), (2, 'ROLE_ADMIN'); 


The app doesn`t have default method for creating admin, so after launching the app for the first time and adding the roles add admin:
INSERT INTO public.t_user_roles(user_id, roles_id)
  VALUES (1, 2);


