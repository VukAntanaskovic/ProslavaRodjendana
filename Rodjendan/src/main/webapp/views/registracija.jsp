<form action="RegistracijaServlet" class="loginForma" method="POST">
        <h2>REGISTRACIJA</h2>
        <input type="text" placeholder="Ime" name="ime">
        <input type="text" placeholder="Prezime" name="prezime">
        <input type="mail" placeholder="Email" name="email">
        <input type="password" placeholder="Password" name="password">
        <input type="submit" value="Registrujte se">
        <a id="nazad" href="index.jsp">Nazad na prijavu</a>
        <% 
        HttpSession sesija = request.getSession();
        String poruka = (String) sesija.getAttribute("poruka");
        %>
        <%if(poruka != null && poruka != ""){%>
        	
     <div  class="poruka">
        <p><%=poruka %>  <button type="button" onclick="zatvoriPoruku()">x</button></p>
    </div>
    <style>
    .poruka{
    display:block;
    }
    </style>
        	<% 
        	sesija.setAttribute("poruka", "");
        }
        
        %>
    </form>