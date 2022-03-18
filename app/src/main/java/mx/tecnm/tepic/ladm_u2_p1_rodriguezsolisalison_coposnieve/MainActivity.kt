package mx.tecnm.tepic.ladm_u2_p1_rodriguezsolisalison_coposnieve

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import mx.tecnm.tepic.ladm_u2_p1_rodriguezsolisalison_coposnieve.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(Lienzo(this))
    }
}