using System;
using System.Collections.Generic;
using System.Threading.Tasks;
using Moq;
using MS.Application.Interface;
using MS.Dto;
using Xunit;

namespace MS.Tests
{
    public class EventoServiceTests
    {
        private readonly Mock<IEventoService> _eventoServiceMock;

        public EventoServiceTests()
        {
            _eventoServiceMock = new Mock<IEventoService>();
        }

        [Fact]
        public async Task CreateEvento_ShouldReturnSuccess()
        {
            // Arrange
            var fechaEvento = DateTime.Now;
            var lugarEvento = "Lugar de prueba";
            var descripcionEvento = "Descripci�n de prueba";
            var precio = 100m;
            _eventoServiceMock.Setup(service => service.CreateEvento(fechaEvento, lugarEvento, descripcionEvento, precio))
                .ReturnsAsync(new RespuestaGenerica<bool> { EsValida = true, Mensaje = "Evento creado con �xito", Resultado = true });

            // Act
            var result = await _eventoServiceMock.Object.CreateEvento(fechaEvento, lugarEvento, descripcionEvento, precio);

            // Assert
            Assert.True(result.EsValida);
            Assert.Equal("Evento creado con �xito", result.Mensaje);
            Assert.True(result.Resultado);
        }

        [Fact]
        public async Task UpdateEvento_ShouldReturnSuccess()
        {
            // Arrange
            var idEvento = 1;
            var fechaEvento = DateTime.Now;
            var lugarEvento = "Lugar actualizado";
            var descripcionEvento = "Descripci�n actualizada";
            var precio = 150m;
            _eventoServiceMock.Setup(service => service.UpdateEvento(idEvento, fechaEvento, lugarEvento, descripcionEvento, precio))
                .ReturnsAsync(new RespuestaGenerica<bool> { EsValida = true, Mensaje = "Evento actualizado con �xito", Resultado = true });

            // Act
            var result = await _eventoServiceMock.Object.UpdateEvento(idEvento, fechaEvento, lugarEvento, descripcionEvento, precio);

            // Assert
            Assert.True(result.EsValida);
            Assert.Equal("Evento actualizado con �xito", result.Mensaje);
            Assert.True(result.Resultado);
        }

        [Fact]
        public async Task DeleteEvento_ShouldReturnSuccess()
        {
            // Arrange
            var idEvento = 1;
            _eventoServiceMock.Setup(service => service.DeleteEvento(idEvento))
                .ReturnsAsync(new RespuestaGenerica<bool> { EsValida = true, Mensaje = "Evento eliminado con �xito", Resultado = true });

            // Act
            var result = await _eventoServiceMock.Object.DeleteEvento(idEvento);

            // Assert
            Assert.True(result.EsValida);
            Assert.Equal("Evento eliminado con �xito", result.Mensaje);
            Assert.True(result.Resultado);
        }

        [Fact]
        public async Task GetEventoById_ShouldReturnEvento()
        {
            // Arrange
            var idEvento = 1;
            var eventoDto = new EventoDto { Id = idEvento, FechaEvento = DateTime.Now, LugarEvento = "Lugar de prueba", DescripcionEvento = "Descripci�n de prueba", Precio = 100m };
            _eventoServiceMock.Setup(service => service.GetEventoById(idEvento))
                .ReturnsAsync(new RespuestaGenerica<EventoDto> { EsValida = true, Mensaje = "Evento encontrado", Resultado = eventoDto });

            // Act
            var result = await _eventoServiceMock.Object.GetEventoById(idEvento);

            // Assert
            Assert.True(result.EsValida);
            Assert.Equal("Evento encontrado", result.Mensaje);
            Assert.Equal(eventoDto, result.Resultado);
        }

        [Fact]
        public async Task GetEventos_ShouldReturnEventos()
        {
            // Arrange
            var eventos = new List<EventoDto>
            {
                new EventoDto { Id = 1, FechaEvento = DateTime.Now, LugarEvento = "Lugar 1", DescripcionEvento = "Descripci�n 1", Precio = 100m },
                new EventoDto { Id = 2, FechaEvento = DateTime.Now, LugarEvento = "Lugar 2", DescripcionEvento = "Descripci�n 2", Precio = 200m }
            };
            _eventoServiceMock.Setup(service => service.GetEventos())
                .ReturnsAsync(new RespuestaGenerica<IEnumerable<EventoDto>> { EsValida = true, Mensaje = "Eventos encontrados", Resultado = eventos });

            // Act
            var result = await _eventoServiceMock.Object.GetEventos();

            // Assert
            Assert.True(result.EsValida);
            Assert.Equal("Eventos encontrados", result.Mensaje);
            Assert.Equal(eventos, result.Resultado);
        }
    }
}
