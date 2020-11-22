
<main class="page login-page">
    <section class="clean-block clean-form dark">
        <div class="container">
            <div class="block-heading">
                <h2 class="text-info">Log In</h2>
            </div>
            <form action="login/auth" method="post">
                <div class="form-group"><label for="username">Username</label><input class="form-control item" type="text" id="username" name="username"></div>
                <div class="form-group"><label for="password">Password</label><input class="form-control" type="password" id="password" name="password"></div>
                <g:if test="${flash.error}">
                    <p style="color: red">${flash.error}</p>
                </g:if>
                <div class="form-group">
                </div><button class="btn btn-primary btn-block" type="submit">Log In</button>
                <div class="form-group"><a href="/login/registro">Registrarse</a> </div>
            </form>
        </div>
    </section>
</main>

