package mx.tecnm.tepic.ladm_u2_p1_rodriguezsolisalison_coposnieve

import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Path
import android.util.Log
import android.view.View
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class Lienzo(este:MainActivity): View(este) {
    val este = este
    val copos = Array<CoposNieve>(1500,{ CoposNieve(this)})
    val intensidad: DoubleArray = doubleArrayOf(0.0,0.1,0.53,1.0)//cada uno se multiplica por el número de copos
    var selector = 0

    val corrutina = GlobalScope.launch {
        var tiempo = 0L
        while (true){
            este.runOnUiThread {
                invalidate()
            }
            tiempo += 20

            if(tiempo == 8000L){ //8 seg
                selector++ //cambia de intensidad
                tiempo = 0 //tiempo regresa a 0 para que tarde otros 8 seg
                if (selector == 4) selector = 0 //reinicia estado principal, 3 para estado máximo.
            }
            delay(20L)


        }
    }
    //var circulos = Array<Circulo>
    var luna = 0

    override fun onDraw(c: Canvas) {
        super.onDraw(c)
        val p = Paint()
        c.drawColor(Color.rgb(15,163,188))

//--------------------------------------------------------------------------------------------------
        //DIBUJO LA LUNA.
        p.color = Color.WHITE
        c.drawCircle(100f + luna, 100f, 100f, p)
        p.color = Color.rgb(15,163,188)//REDIBUJO
        c.drawCircle(135f + luna, 125f, 100f, p)
//--------------------------------------------------------------------------------------------------
        //DIBUJO UN CERRITO VERDE.
        p.color = Color.GREEN
        c.drawCircle(500f, 1900f, 900f, p)
        //LE PONGO ALREDEDOR COLOR DEL MISMO.
        p.style = Paint.Style.FILL
        p.strokeWidth = 10f
        p.color = Color.GREEN
        c.drawCircle(1000f, 2600f, 2000f, p)
        //REDIBUJAMOS EL ESTILO
        p.style = Paint.Style.FILL
//--------------------------------------------------------------------------------------------------
        //DIBUJO ARBOLITO 1
        p.color = Color.rgb(128, 64, 0)
        c.drawRect(200f, 650f, 295f, 930f, p)
        //CON UN OVALO DIBUJO LA ESTRUCTURA COMO EL EJEMPLO
        p.color = Color.YELLOW
        c.drawOval(150f, 600f, 345f, 800f, p)
        //ESTRUCTURA DE ALREDEDOR, CONTORNO.
        p.style = Paint.Style.STROKE
        p.strokeWidth = 2f
        p.color = Color.WHITE
        c.drawOval(150f, 600f, 345f, 800f, p)

        //REDIBUJAMOS
        //REDIBUJAMOS LOS ESTILOS.
        p.style = Paint.Style.FILL
        p.color = Color.YELLOW
        c.drawOval(150f, 475f, 345f, 675f, p)
        //CONOTRNO.
        p.style = Paint.Style.STROKE
        p.strokeWidth = 2f
        p.color = Color.WHITE
        c.drawOval(150f, 475f, 345f, 675f, p)
        p.style = Paint.Style.FILL

        //SEGUNDO ARBOLITO

        //DIBUJO OTRO ARBOLITO COMO EN EL EJEMPLO.
        p.color = Color.rgb(128, 64, 0)
        c.drawRect(600f, 650f, 700f, 930f, p)
        //ESTRUCTURA SIMULADA
        p.color = Color.GREEN
        c.drawOval(550f, 600f, 745f, 800f, p)
        //ALREDEDOR DE LA ESTRUCTURA
        p.style = Paint.Style.STROKE
        p.strokeWidth = 2f
        p.color = Color.WHITE
        c.drawOval(550f, 600f, 745f, 800f, p)

        //REDIBUJAMOS LA ESTRUCTURA
        //REDIBUJAMOS LOS ESTILOS INICIALES
        p.style = Paint.Style.FILL
        p.color = Color.GREEN
        c.drawOval(550f,475f,745f,675f,p)
        //ALREDEDOR DE LA ESTRUCTURA QUE QUIERO QUE LLEVE.
        p.style = Paint.Style.STROKE
        p.strokeWidth = 2f
        p.color = Color.WHITE
        c.drawOval(550f,475f,745f,675f,p)
        p.style = Paint.Style.FILL
        //------------------------------------------------------------------------------------------
        //Dibujar casa
        p.color = Color.rgb(144,130,101)
        c.drawRect(1300f,650f,1900f,950f,p)

        //DIBUJO LA PUERTA
        p.color = Color.rgb(243,84,84)
        c.drawRect(1400f,750f,1500f,950f,p)

        //DIBUJAR MANESILLA DE LA PUERTA
        p.color = Color.BLACK
        c.drawCircle(1485f,845f,10f,p)

        //DIBUJAR VENTANA
        p.color = Color.BLACK
        c.drawRect(1685f,720f,1800f,845f,p)

        //DIBUJA EL TECHO
        p.color = Color.rgb(52,57,62)
        p.style = Paint.Style.FILL
        var path = Path()
        path.moveTo(1300f, 650f)
        path.lineTo(1900f, 650f)
        path.lineTo(1590f, 450f)
        c.drawPath(path,p)
//--------------------------------------------------------------------------------------------------
        val limite:Int = ((copos.size-1)*intensidad[selector]).toInt() //cantidad * intensidad y pasamos selector

        (0..limite).forEach {
            copos[it].moverCopo()
            copos[it].pintar(c)
        }
    }

    //----------------------------------------------------------------------------------------------


}