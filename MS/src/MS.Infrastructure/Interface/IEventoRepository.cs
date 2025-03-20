using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using MS.Domain.Entity;

namespace MS.Infrastructure.Interface
{
    public interface IEventoRepository
    {
        public Task CreateEvento(DateTime fechaEvento,
            string lugarEvento, string descripcionEvento, decimal precio);
        public Task UpdateEvento(int idEvento, DateTime fechaEvento,
            string lugarEvento, string descripcionEvento, decimal precio);
        public Task DeleteEvento(int idEvento);
        public Task<Evento?> GetEventoById(int idEvento);
        public Task<IEnumerable<Evento>> GetEventos();
    }
}
