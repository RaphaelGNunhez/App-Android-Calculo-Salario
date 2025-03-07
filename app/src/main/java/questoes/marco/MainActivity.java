package questoes.marco;

import android.os.Bundle;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText txtNum;
    private RadioGroup grupoPerc;
    private Button btnCalc;
    private TextView txtResul;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        txtNum = findViewById(R.id.txtNum);
        grupoPerc = findViewById(R.id.grupoPerc);
        btnCalc = findViewById(R.id.btnCalc);
        txtResul = findViewById(R.id.txtResul);

        btnCalc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calcularNovoSal();
            }
        });

    }
    private void calcularNovoSal(){
        String salarioStr = txtNum.getText().toString();

        if (salarioStr.isEmpty()){
            txtResul.setText("Por favor, digite um salário válido!");
            return;
        }

        double sal = Double.parseDouble(salarioStr);
        double perc = 0;

        int selecionado = grupoPerc.getCheckedRadioButtonId();
        if (selecionado == R.id.btn40){
            perc = 0.40;
        } else if (selecionado == R.id.btn45){
            perc = 0.45;
        } else if (selecionado == R.id.btn50){
            perc = 0.50;
        } else {
            txtResul.setText("Selecione um percentual");
            return;
        }
        double novoSal = sal + (sal * perc);

        txtResul.setText("R$ " + novoSal);
    }
}