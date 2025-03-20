using Microsoft.Extensions.DependencyInjection;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using MS.Infrastructure.Data;
using MS.Infrastructure.Interface;
using MS.Infrastructure.Repository;

namespace MS.Infrastructure
{
    public static class ConfigurateServices
    {
        public static IServiceCollection ConfigurarInfraestructura(this IServiceCollection services)
        {
            services.AddTransient<IConnectionService, ConnectionService>();
            services.AddTransient<IEventoRepository, EventoRepository>();
            return services;
        }
    }
}
