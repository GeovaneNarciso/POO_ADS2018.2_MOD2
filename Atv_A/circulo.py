import copy


class circulo:
    def __init__(self, centro, raio):
        self.centro = centro
        self.raio = raio

    def ponto_no_circulo(self, circulo, ponto):
        return ponto.distancia_entre_pontos(circulo.centro) <= circulo.raio

    def retangulo_no_circulo(self, circulo, retangulo):
        ponto = copy.copy(retangulo.canto)
        if not circulo.ponto_no_circulo(circulo, ponto):
            return False
        ponto.x += retangulo.largura
        if not circulo.ponto_no_circulo(circulo, ponto):
            return False
        ponto.y -= retangulo.altura
        if not circulo.ponto_no_circulo(circulo, ponto):
            return False
        ponto.x -= retangulo.largura
        if not circulo.ponto_no_circulo(circulo, ponto):
            return False
        return True

    def canto_retangulo_no_circulo(self, circulo, retangulo):
        ponto = copy.copy(retangulo.canto)
        if circulo.ponto_no_circulo(circulo, ponto):
            return True
        ponto.x += retangulo.largura
        if circulo.ponto_no_circulo(circulo, ponto):
            return True
        ponto.y -= retangulo.altura
        if circulo.ponto_no_circulo(circulo, ponto):
            return True
        ponto.x -= retangulo.largura
        if circulo.ponto_no_circulo(circulo, ponto):
            return True
        return False

class ponto:
    def __init__(self, x, y):
        self.x = x
        self.y = y

    def distancia_entre_pontos(self, ponto2):
        distancia = ((self.x - ponto2.x) ** 2 + (self.y - ponto2.y) ** 2) ** 0.5
        return distancia

class retangulo:
    def __init__(self, largura, altura, canto):
        self.largura = largura
        self.altura = altura
        self.canto = canto

def main():
    ponto_a = ponto(150, 100)
    circulo_a = circulo(ponto_a, 75)
    ponto_b = ponto(200, 50)
    ponto_c = ponto(300, 100)
    retangulo_a = retangulo(30, 40, ponto_a)
    print("Ponto no círculo: ", circulo_a.ponto_no_circulo(circulo_a, ponto_b))
    print("Ponto no círculo: ", circulo_a.ponto_no_circulo(circulo_a, ponto_c))
    print("Retângulo no círculo: ", circulo_a.retangulo_no_circulo(circulo_a, retangulo_a))
    print("Canto do retângulo no círculo: ", circulo_a.canto_retangulo_no_circulo(circulo_a, retangulo_a))

if __name__ == '__main__':
    main()
