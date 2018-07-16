package com.pokemon.toronto.game.com.pokemon.toronto.factory;

import com.pokemon.toronto.game.com.pokemon.toronto.area.DiglettCave;
import com.pokemon.toronto.game.com.pokemon.toronto.area.MtMoon1F;
import com.pokemon.toronto.game.com.pokemon.toronto.area.MtMoonB1F;
import com.pokemon.toronto.game.com.pokemon.toronto.area.MtMoonB2F;
import com.pokemon.toronto.game.com.pokemon.toronto.area.PokemonMansion1F;
import com.pokemon.toronto.game.com.pokemon.toronto.area.PokemonMansionB1F;
import com.pokemon.toronto.game.com.pokemon.toronto.area.PokemonTower;
import com.pokemon.toronto.game.com.pokemon.toronto.area.PowerPlant;
import com.pokemon.toronto.game.com.pokemon.toronto.area.RockTunnel;
import com.pokemon.toronto.game.com.pokemon.toronto.area.Route;
import com.pokemon.toronto.game.com.pokemon.toronto.area.Route1;
import com.pokemon.toronto.game.com.pokemon.toronto.area.Route10;
import com.pokemon.toronto.game.com.pokemon.toronto.area.Route11;
import com.pokemon.toronto.game.com.pokemon.toronto.area.Route12;
import com.pokemon.toronto.game.com.pokemon.toronto.area.Route13;
import com.pokemon.toronto.game.com.pokemon.toronto.area.Route16;
import com.pokemon.toronto.game.com.pokemon.toronto.area.Route18;
import com.pokemon.toronto.game.com.pokemon.toronto.area.Route2;
import com.pokemon.toronto.game.com.pokemon.toronto.area.Route21;
import com.pokemon.toronto.game.com.pokemon.toronto.area.Route23;
import com.pokemon.toronto.game.com.pokemon.toronto.area.Route24;
import com.pokemon.toronto.game.com.pokemon.toronto.area.Route3;
import com.pokemon.toronto.game.com.pokemon.toronto.area.Route4;
import com.pokemon.toronto.game.com.pokemon.toronto.area.Route6;
import com.pokemon.toronto.game.com.pokemon.toronto.area.Route7;
import com.pokemon.toronto.game.com.pokemon.toronto.area.Route8;
import com.pokemon.toronto.game.com.pokemon.toronto.area.SafariZoneA1;
import com.pokemon.toronto.game.com.pokemon.toronto.area.SafariZoneA2;
import com.pokemon.toronto.game.com.pokemon.toronto.area.SafariZoneA3;
import com.pokemon.toronto.game.com.pokemon.toronto.area.SafariZoneCenter;
import com.pokemon.toronto.game.com.pokemon.toronto.area.SeafoamB2F;
import com.pokemon.toronto.game.com.pokemon.toronto.area.SeafoamB4F;
import com.pokemon.toronto.game.com.pokemon.toronto.area.VictoryRoad1F;
import com.pokemon.toronto.game.com.pokemon.toronto.area.VictoryRoad2F;
import com.pokemon.toronto.game.com.pokemon.toronto.area.ViridianForest;
import com.pokemon.toronto.game.com.pokemon.toronto.area.johto.CliffCave;
import com.pokemon.toronto.game.com.pokemon.toronto.area.johto.DarkCaveViolet;
import com.pokemon.toronto.game.com.pokemon.toronto.area.johto.IlexForest;
import com.pokemon.toronto.game.com.pokemon.toronto.area.johto.NationalPark;
import com.pokemon.toronto.game.com.pokemon.toronto.area.johto.NationalPark2;
import com.pokemon.toronto.game.com.pokemon.toronto.area.johto.Route29;
import com.pokemon.toronto.game.com.pokemon.toronto.area.johto.Route30;
import com.pokemon.toronto.game.com.pokemon.toronto.area.johto.Route32;
import com.pokemon.toronto.game.com.pokemon.toronto.area.johto.Route34;
import com.pokemon.toronto.game.com.pokemon.toronto.area.johto.Route35;
import com.pokemon.toronto.game.com.pokemon.toronto.area.johto.Route36;
import com.pokemon.toronto.game.com.pokemon.toronto.area.johto.Route37;
import com.pokemon.toronto.game.com.pokemon.toronto.area.johto.Route38;
import com.pokemon.toronto.game.com.pokemon.toronto.area.johto.Route40;
import com.pokemon.toronto.game.com.pokemon.toronto.area.johto.Route41;
import com.pokemon.toronto.game.com.pokemon.toronto.area.johto.Route46;
import com.pokemon.toronto.game.com.pokemon.toronto.area.johto.Route47;
import com.pokemon.toronto.game.com.pokemon.toronto.area.johto.Route48;
import com.pokemon.toronto.game.com.pokemon.toronto.area.johto.RuinsOfAlph;
import com.pokemon.toronto.game.com.pokemon.toronto.area.johto.SproutTower;
import com.pokemon.toronto.game.com.pokemon.toronto.area.johto.TestRoute;
import com.pokemon.toronto.game.com.pokemon.toronto.area.johto.UnionCave1F;
import com.pokemon.toronto.game.com.pokemon.toronto.area.johto.UnionCaveB2F;
import com.pokemon.toronto.game.com.pokemon.toronto.area.misc.Africa;
import com.pokemon.toronto.game.com.pokemon.toronto.area.misc.JurassicPark;
import com.pokemon.toronto.game.com.pokemon.toronto.area.misc.Swamp;

/**
 * Created by Gregory on 7/27/2017.
 */

public class RouteFactory {
    /**
     * Constructor
     */
    public RouteFactory() {}

    /**
     * Create a Route based on a route identification number.
     * @param routeNumber The route identification number.
     * @return A new Route
     */
    public Route createRoute(int routeNumber) {
        //TODO: Create trainer class later and add them to the route.
        if (routeNumber == Route.ROUTE_1) {
            return new Route1();
        } else if (routeNumber == Route.VIRIDIAN_FOREST) {
            return new ViridianForest();
        } else if (routeNumber == Route.ROUTE_2) {
            return new Route2();
        } else if (routeNumber == Route.ROUTE_3) {
            return new Route3();
        } else if (routeNumber == Route.MT_MOON_1F) {
            return new MtMoon1F();
        } else if (routeNumber == Route.MT_MOON_B1F) {
            return new MtMoonB1F();
        } else if (routeNumber == Route.MT_MOON_B2F) {
            return new MtMoonB2F();
        } else if (routeNumber == Route.ROUTE_4) {
            return new Route4();
        } else if (routeNumber == Route.ROUTE_24) {
            return new Route24();
        } else if (routeNumber == Route.ROUTE_6) {
            return new Route6();
        } else if (routeNumber == Route.ROUTE_11) {
            return new Route11();
        } else if (routeNumber == Route.DIGLETT_CAVE) {
            return new DiglettCave();
        } else if (routeNumber == Route.ROUTE_10) {
            return new Route10();
        } else if (routeNumber == Route.ROCK_TUNNEL) {
            return new RockTunnel();
        } else if (routeNumber == Route.POKEMON_TOWER) {
            return new PokemonTower();
        } else if (routeNumber == Route.ROUTE_8) {
            return new Route8();
        } else if (routeNumber == Route.ROUTE_7) {
            return new Route7();
        } else if (routeNumber == Route.ROUTE_16) {
            return new Route16();
        } else if (routeNumber == Route.ROUTE_12) {
            return new Route12();
        } else if (routeNumber == Route.ROUTE_13) {
            return new Route13();
        } else if (routeNumber == Route.ROUTE_18) {
            return new Route18();
        } else if (routeNumber == Route.SAFARI_CENTER) {
            return new SafariZoneCenter();
        } else if (routeNumber == Route.SAFARI_A1) {
            return new SafariZoneA1();
        } else if (routeNumber == Route.SAFARI_A2) {
            return new SafariZoneA2();
        } else if (routeNumber == Route.SAFARI_A3) {
            return new SafariZoneA3();
        } else if (routeNumber == Route.POWER_PLANT) {
            return new PowerPlant();
        } else if (routeNumber == Route.ROUTE_21) {
            return new Route21();
        } else if (routeNumber == Route.POKEMON_MANSION_1F) {
            return new PokemonMansion1F();
        } else if (routeNumber == Route.POKEMON_MANSION_B1F) {
            return new PokemonMansionB1F();
        } else if (routeNumber == Route.SEAFOAM_B2F) {
            return new SeafoamB2F();
        } else if (routeNumber == Route.SEAFOAM_B4F) {
            return new SeafoamB4F();
        } else if (routeNumber == Route.ROUTE_23) {
            return new Route23();
        } else if (routeNumber == Route.VICTORY_ROAD_1F) {
            return new VictoryRoad1F();
        } else if (routeNumber == Route.VICTORY_ROAD_2F) {
            return new VictoryRoad2F();
        }
        /**
         * JOHTO ROUTES
         */
        else if (routeNumber == Route.ROUTE_29) {
            return new Route29();
        } else if (routeNumber == Route.ROUTE_46) {
            return new Route46();
        } else if (routeNumber == Route.ROUTE_30) {
            return new Route30();
        } else if (routeNumber == Route.DARK_CAVE_VIOLET) {
            return new DarkCaveViolet();
        } else if (routeNumber == Route.SPROUT_TOWER) {
            return new SproutTower();
        } else if (routeNumber == Route.ROUTE_32) {
            return new Route32();
        } else if (routeNumber == Route.RUINS_OF_ALPH) {
            return new RuinsOfAlph();
        } else if (routeNumber == Route.UNION_CAVE_1F) {
            return new UnionCave1F();
        } else if (routeNumber == Route.UNION_CAVE_B2F) {
            return new UnionCaveB2F();
        } else if (routeNumber == Route.ROUTE_34) {
            return new Route34();
        } else if (routeNumber == Route.ILEX_FOREST) {
            return new IlexForest();
        } else if (routeNumber == Route.ROUTE_35) {
            return new Route35();
        } else if (routeNumber == Route.NATIONAL_PARK) {
            return new NationalPark();
        } else if (routeNumber == Route.NATIONAL_PARK_2) {
            return new NationalPark2();
        } else if (routeNumber == Route.ROUTE_36) {
            return new Route36();
        } else if (routeNumber == Route.ROUTE_37) {
            return new Route37();
        } else if (routeNumber == Route.ROUTE_38) {
            return new Route38();
        } else if (routeNumber == Route.ROUTE_40) {
            return new Route40();
        } else if (routeNumber == Route.ROUTE_41) {
            return new Route41();
        } else if (routeNumber == Route.ROUTE_47) {
            return new Route47();
        } else if (routeNumber == Route.CLIFF_CAVE) {
            return new CliffCave();
        } else if (routeNumber == Route.ROUTE_48) {
            return new Route48();
        }
        //Test Route
        else if (routeNumber == Route.TEST_ROUTE) {
            return new TestRoute();
        } else if (routeNumber == Route.SWAMP) {
            return new Swamp();
        } else if (routeNumber == Route.AFRICA) {
            return new Africa();
        } else if (routeNumber == Route.JURASSIC_PARK) {
            return new JurassicPark();
        }
        return null;
    }

}
