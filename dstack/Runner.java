package com.mycompany.dstack;

/**
 *
 * @author Leonardo Barros
 */
public class Runner {
    public static void main(String[] args) {
        DStack stack = new DStack(4);
        
        // Question one
        stack.push("Alfredo");
        stack.push("Ana");
        stack.push("Bernardo");
        stack.push("Janaina");
        stack.push("Helena");
        
        // Question two
        System.out.println(stack.stack[0]);
        
        // Question three
        System.out.println(stack.pop());

        // Question four
        System.out.println(stack.topElement());
        
        // Question five
        System.out.println("Está vazia? " + stack.isEmpty());
        
        // Question sext
        System.out.println("Quantidade de elementos: " + stack.size());
        
        // Question seven
        System.out.println(stack.checkDepthOfName("Ana"));
    }
    
}
