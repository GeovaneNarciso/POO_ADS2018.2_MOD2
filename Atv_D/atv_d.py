class ventilador:
    def __init__(self, marca, modelo):
        self.marca = marca
        self.modelo = modelo
        self.energia = False
        self.girar = False
        self.velocidade = 0

    def __str__(self):
        if self.energia:
            print("\nEnergia: Ligado")
            if self.girar:
                print("Giro: Ativado")
            else:
                print("Giro: Desativado")
        else:
            print("Energia: Desligado")
            print("Giro: Desativado")
        print("Marca: {}".format(self.marca))
        print("Modelo: {}".format(self.modelo))
        print("Velocidade: {}".format(self.velocidade))

    def ligar_desligar(self):
        if self.energia:
            self.energia = False
            self.girar = False
            self.velocidade = 0
        else:
            self.energia = True

    def giro(self):
        if self.energia:
            if self.girar:
                self.girar = False
            else:
                self.girar = True

    def mais_velocidade(self):
        if self.energia:
            if self.velocidade < 3:
                self.velocidade += 1

    def menos_velocidade(self):
        if self.energia:
            if self.velocidade > 0:
                self.velocidade -= 1

def main():
    V_1 = ventilador("Houston", "B25A")
    V_1.__str__()
    V_1.ligar_desligar()
    V_1.mais_velocidade(), V_1.mais_velocidade(), V_1.mais_velocidade()
    V_1.__str__()
    V_1.menos_velocidade()
    V_1.giro()
    V_1.__str__()

if __name__ == '__main__':
    main()
