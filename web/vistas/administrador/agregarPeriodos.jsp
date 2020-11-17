<%@include file="header.jsp" %>

<div class="col"> <div>

        <h1>Agregar Periodo</h1>
        <form action="admin?tipo=agregarPeriodo" method="post">
            <input class="form-control" type="text" name="txtNombre" required="" value=""><br>
            <input class="btn btn-success" type="submit" name="accion" value="agregarPeriodo"><br>
        </form>          
        </div>
</div>

<%@include file="footer.jsp" %>