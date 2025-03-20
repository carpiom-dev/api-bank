using Microsoft.Extensions.DependencyInjection;
using MS.Application.Interface;
using MS.Application.Service;
using MS.Infrastructure;

namespace MS.Application
{
    public static class ConfigurateService
    {
        public static IServiceCollection ConfigurarAplicacion(this IServiceCollection services)
        {
            services.ConfigurarInfraestructura();
            services.AddTransient<IEventoService, EventoService>();
            return services;
        }
    }
}
