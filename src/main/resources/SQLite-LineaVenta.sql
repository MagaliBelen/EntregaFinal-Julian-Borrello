CREATE TABLE LineaVenta (
    id INT AUTO_INCREMENT PRIMARY KEY,
    cantidad INT,
    precioUnitario DECIMAL(10, 2),
    producto_id INT,
    comprobante_id INT,
    FOREIGN KEY (producto_id) REFERENCES Producto(id),
    FOREIGN KEY (comprobante_id) REFERENCES Comprobante(id)
);
