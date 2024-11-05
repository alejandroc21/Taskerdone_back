package com.alejandroct.taskerdone.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
/**
 *Can be used by a class to sort the id's in a list of objects using strings.
 *  <pre>
 *  Example:
 *  list of objects: [{id:1, name:one},{id:2, name:two},{id:3, name:three}]
 *
 *  we can order them like this "1,2,3" or like this "3,2,1" without making any
 *  changes in the original list.
 *  </pre>
 */
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class OrderManager {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    /**
     * You can store the id's like this "1,2,3".
     */
    @Pattern(regexp = "^$|^[\\d,]+$", message = "The value can only contain numbers separated by commas or remain empty.")
    private String idsList="";
}
