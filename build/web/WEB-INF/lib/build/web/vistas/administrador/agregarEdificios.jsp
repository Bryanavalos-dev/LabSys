<%@include file="header.jsp" %>

<div class="col"> <div>

        <h1>Agregar edificios</h1>
        <form action="admin?tipo=agregarEdificio" method="post">
            <input class="form-control" type="text" name="txtNombre" required="" value=""><br>
            <input class="btn btn-success" type="submit" name="accion" value="agregarEdificio"><br>
        </form>          
        </div>
</div>

<%@include file="footer.jsp" %>