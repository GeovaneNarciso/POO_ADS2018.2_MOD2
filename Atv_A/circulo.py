class circulo:
    def __init__(self, centro, raio):
        self.centro = centro
        self.raio = raio

    def ponto_no_circulo(self, circulo, ponto):
        return ponto.distancia_entre_pontos(circulo.centro) <= circulo.raio

class ponto:
    def __init__(self, x, y):
        self.x = x
        self.y = y

    def distancia_entre_pontos(self, ponto2):
        distancia = ((self.x - ponto2.x) ** 2 + (self.y - ponto2.y) ** 2) ** 0.5
        return distancia

def main():
    ponto_a = ponto(150, 100)
    circulo_a = circulo(ponto_a, 75)
    ponto_b = ponto(200, 50)
    ponto_c = ponto(300, 100)
    print(circulo_a.ponto_no_circulo(circulo_a, ponto_b))
    print(circulo_a.ponto_no_circulo(circulo_a, ponto_c))

if __name__ == '__main__':
    main()
