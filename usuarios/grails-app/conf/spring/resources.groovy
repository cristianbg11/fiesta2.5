import com.usuarios.CustomAppRestAuthTokenJsonRenderer
import com.usuarios.UserPasswordEncoderListener
// Place your Spring DSL code here
beans = {
    userPasswordEncoderListener(UserPasswordEncoderListener)
    // For overriding the token json renderer
    accessTokenJsonRenderer(CustomAppRestAuthTokenJsonRenderer)
}
