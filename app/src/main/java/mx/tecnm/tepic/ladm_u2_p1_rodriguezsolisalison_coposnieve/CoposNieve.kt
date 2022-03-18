package mx.tecnm.tepic.ladm_u2_p1_rodriguezsolisalison_coposnieve

import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import kotlin.random.Random

class CoposNieve(l:Lienzo) {
    var x= 0f
    var y = 0f
    var tam = 0f

    init {
        x= (Math.random()*2340).toFloat()
        y = ((Math.random()*-1800)).toFloat()
        tam = ((Math.random()*5)+5).toFloat()
    }

    fun moverCopo(){
        y += ((Math.random() * 4) + 10).toFloat()
        if(y >= 1000){
            y = ((Math.random()*-50)-50).toFloat()
        }
    }

    fun pintar(canvas: Canvas){
        var p = Paint()
        p.color = Color.WHITE
        canvas.drawCircle(x,y,5f,p)
    }
}