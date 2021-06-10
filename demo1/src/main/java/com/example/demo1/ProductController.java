package com.example.demo1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {

    @Autowired
    public ProductRepo repo;

    @PostMapping("/post")
    public String get(@RequestBody Product product){

        repo.save(product);

        if (product.getOperation()=='+'){
            product.setResult(product.getInput1()+ product.getInput2());
        }else if (product.getOperation()=='-'){
            product.setResult(product.getInput1() - product.getInput2());
        }else if (product.getOperation()=='*'){
            product.setResult(product.getInput1() * product.getInput2());
        }else if (product.getOperation()=='/'){
            product.setResult(product.getInput1() / product.getInput2());
        }

        return product.toString();

    }

}
