package com.tecdes.aluguel;
import com.tecdes.aluguel.controller.AluguelController;
import com.tecdes.aluguel.repository.AluguelRepository;
import com.tecdes.aluguel.view.AluguelForm;

public class AppAluguel {
    public static void main(String[] args) {
        AluguelRepository repo = new AluguelRepository();
        AluguelController controller = new AluguelController();
        new AppAluguel(controller);
    }
    public AppAluguel(AluguelController controller) {
        // Aqui você pode inicializar a interface ou lógica usando o controller
        AluguelForm form = new AluguelForm(controller);
    }
    
}