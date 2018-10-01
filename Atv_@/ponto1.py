class ponto:
    def __init__(self, x, y):
        self.x = x
        self.y = y

    def distancia_entre_pontos(self, ponto2):
        distancia = ((self.x - ponto2.x) ** 2 + (self.y - ponto2.y) ** 2) ** 0.5
        return distancia

    def quadrante(self):
        if self.x == 0 and self.y == 0:
            quadrante = "Ponto de origem."
        elif self.x == 0:
            quadrante = "Eixo Y."
        elif self.y == 0:
            quadrante = "Eixo X."
        elif self.x > 0:
            if self.y > 0:
                quadrante = "Quadrante 1."
            else:
                quadrante = "Quadrante 4."
        elif self.x < 0:
            if self.y > 0:
                quadrante = "Quadrante 2."
            else:
                quadrante = "Quadrante 3."
        return quadrante

    def mover(self, x2, y2):
        self.x = x2
        self.y = y2

def main():
    x1 = int(input("Informe a coordenada X do ponto A: "))
    y1 = int(input("Informe a coordenada Y do ponto A: "))
    x2 = int(input("Informe a coordenada X do ponto B: "))
    y2 = int(input("Informe a coordenada Y do ponto B: "))

    ponto_a = ponto(x1, y1)
    ponto_b = ponto(x2, y2)

    print("\nPonto A: ", ponto_a.x, ponto_a.y)
    x3 = int(input("Informe a nova coordenada X do ponto A: "))
    y3 = int(input("Informe a nova coordenada Y do ponto A: "))
    ponto_a.mover(x3, y3)
    print("\nPonto A: ", ponto_a.x, ponto_a.y)
    distancia = ponto_a.distancia_entre_pontos(ponto_b)
    quadrante = ponto_a.quadrante()
    print("\nDistância entre o ponto A e o ponto B: ", distancia)
    print("\nLocalização do ponto A: ", quadrante)


if __name__ == '__main__':
    main()
