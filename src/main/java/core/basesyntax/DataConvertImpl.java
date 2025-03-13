package core.basesyntax.service;

import core.basesyntax.service.model.FruitTransaction;
import java.util.ArrayList;
import java.util.List;

public class DataConvertImpl implements DataConverter {

    @Override
    public List<FruitTransaction> convertToTransaction(List<String> lines) {
        List<FruitTransaction> transactions = new ArrayList<>();
        for (int i = 0; i < lines.size(); i++) {
            String[] components = lines.get(i).split(",");
            if (components.length != 3) {
                throw new IllegalArgumentException("Invalid line format: " + lines);
            }

            FruitTransaction.Operation operation = FruitTransaction.Operation
                    .fromCode(components[0]);
            String fruit = components[1];
            int quantity = Integer.parseInt(components[2]);
            transactions.add(new FruitTransaction(operation, fruit, quantity));
        }
        return transactions;
    }
}
