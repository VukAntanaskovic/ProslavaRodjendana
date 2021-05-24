<form action="LoginServlet" class="loginForma" method="POST">
        <h2>LOGIN</h2>
        <input type="mail" placeholder="Email" name="email">
        <input type="password" placeholder="Password" name="password">
        <input type="submit" value="Prijavite se">
        <hr>ILI<hr><br>
        <a href="index.jsp?p=registracija">Registrujte se</a>
    </form>
    
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
    background-color:tomato;
    }
    .poruka button{
    border: none;
    font-family: 'Ubuntu', sans-serif;
    font-weight: bold;
    background-color: #fc3535;
    font-size: 0.8em;
    border-radius: 20px;
    color: white;
    cursor: pointer;
    padding: auto;
    transition-duration: 0.2s;
}
.poruka button:hover{
    background-color: #fc6f6f;
}
    </style>
        	<% 
        	sesija.setAttribute("poruka", "");
        }
        
        %>