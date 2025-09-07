# Ideas - Practica02

## Flujo del sistema
### Flujo principal
1\. El robot esta dormido.  
2\. Un cliente llama al robot.  
3\. El robot atiende al cliente.  
4\. El cliente ordena **una** pizza, **un** helado o ambos.  
5\. El robot pide confirmacion.  
6\. El  cliente confirma la orden.  
7\. El robot prepara la orden **cuando se le indique**.  
8\. El robot termina la orden.  
9\. El cliente solicida la entrega de su orden.  
10\. El robot entrega la orden y un ticket con precios individuales y total.  
11\. El robot se duerme.  

### Flujos alternos
3.1. Otro cliente llama al robot.  
3.2. El robot le pide que espere.  
3.3. El robot sigue atendiendo al otro cliente.

4.1. El cliente ordena dos cosas del mismo producto.  
4.2. El robot le pide ordernar solo una cosa de cada producto.  
4.3. El cliente vuelve a ordenar.

6.1. El cliente cancela la orden.  
6.2. El robot vuelve a dormir.

## Implementacion de patrones
### State
Su implementación es en el robot.

**Estados**:
- **Dormido**
- **Mesero**
- **Chef**
- **Repartidor**

**Comportamientos**:
- **Dormir**
- **Atender**
- **Cocinar**
- **Entregar**

### Template
Su implementación es en la preparación de pizzas (puede ser vegetarina). Solo hay tres cosas que cambian:
- masa
- queso
- proteina

### Decorator
Su implementación es en los helados, ya que los "decoramos" con los ingredientes durante su preparación.

> **Base**: Helado (clase abstracta)
>
> - **Sabores**: (heredan del helado)
>   - fresa
>   - vainilla
>   - chocolate
>
>
> **Ingrediente**: Decorador (clase abstracta, hereda del helado)
>
> - **Ingredientes extras**: Solo tres (hereda del Ingrediente)
>   - gomitas de gusano
>   - gomitas de panda
>   - gomitas de aro
>   - chispas de chocolate
>   - malvaviscos
>   - fresitas
>   - manguitos
>   - kiwis
