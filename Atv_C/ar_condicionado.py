class ar_condicionado:
    def __init__(self, marca, potencia, modelo):
        self.marca = marca
        self.potencia = potencia
        self.modelo = modelo
        self.ligado = False
        self.temperatura = 20
        self.velocidade = 1
        self.swing = False

    def altera_estado(self):
        if self.ligado == True:
            self.ligado = False
        else:
            self.ligado = True

    def mudar_temperatura(self, temperatura):
        if self.ligado == True:
            if temperatura > 15 and temperatura < 29:
                self.temperatura = temperatura

    def mais_velocidade(self):
        if self.ligado == True:
            if self.velocidade < 3:
                self.velocidade += 1

    def menos_velocidade(self):
        if self.ligado == True:
            if self.velocidade > 1:
                self.velocidade -= 1

    def pw_swing(self):
        if self.ligado == True:
            if self.swing == True:
                self.swing = False
            else:
                self.swing = True

    def status(self):
        print("\n##### STATUS #####")
        print("Marca: ", self.marca)
        print("Modelo: ", self.modelo)
        print("Potência(btus): ", self.potencia)
        if self.ligado == True:
            print("Estado: Ligado.")
            print("Temperatura: ", self.temperatura)
            print("Velocidade: ", self.velocidade)
            if self.swing == True:
                print("Swing: ativado.")
            else:
                print("Swing: desativado")
        else:
            print("Estado: Desligado")
            print("Temperatura: 0")
            print("Velocidade: 0")
            print("Swing: desativado")

def main():
    AC1 = ar_condicionado("Consul", 9000, "RB5000")
    AC1.status()
    AC1.altera_estado()
    AC1.status()
    temperatura = int(input("\nInforme a temperatura: "))
    AC1.mudar_temperatura(temperatura)
    AC1.mais_velocidade()
    AC1.pw_swing()
    AC1.status()

if __name__ == '__main__':
    main()
