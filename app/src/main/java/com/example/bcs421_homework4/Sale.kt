package com.example.bcs421_homework4

/**
 * Class representing a sale entity.
 * @property name The name associated with the sale.
 * @property amount The amount of the sale.
 * @constructor Creates a Sale object with provided name and amount.
 */
class Sale(var name: String, var amount: Double) {
    /**
     * Secondary constructor to create a Sale object with default values.
     * Used when no parameters are provided.
     */
    constructor() : this("NAME EMPTY", 0.0)
}